package com.transverse.rbac.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.transverse.rbac.dao.UserDao;
import com.transverse.rbac.model.Module;
import com.transverse.rbac.model.ModuleDto;
import com.transverse.rbac.model.Role;
import com.transverse.rbac.model.RoleDto;
import com.transverse.rbac.model.User;
import com.transverse.rbac.model.UserDto;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
    public User save(UserDto user) {
	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    	    Set<Role> set = new HashSet<>();
	    List<RoleDto> roleDtoList = user.getRoleDtoList();
	    for(RoleDto roleDto : roleDtoList) {
	    	Role role = new Role();

	    role.setName(roleDto.getName());
	    role.setDescription(roleDto.getDescription());
	    set.add(role);
	    newUser.setRoles(set);
	    }
	   
	    
        return userDao.save(newUser);
    }

	@Override
	public User patchUser(Long id, UserDto user) {
		Optional<User> oldUser = userDao.findById(id);
		if(oldUser.isPresent()) {
			
			List<ModuleDto> moduleDtoList = user.getModuleList();
			Set<Module> moduleSet = new HashSet<>();
			for(ModuleDto moduleDto : moduleDtoList) {
				Module module = new Module();
				module.setUser(oldUser.get());
				module.setModuleName(moduleDto.getModuleName());
				moduleSet.add(module);
			    oldUser.get().setModuleList(moduleSet);
			}
			
		}
		return userDao.save(oldUser.get());
	}


}
