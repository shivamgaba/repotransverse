package com.transverse.rbac.service;

import java.util.List;

import com.transverse.rbac.model.User;
import com.transverse.rbac.model.UserDto;

public interface UserService {

	User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
    User patchUser(Long id, UserDto user);
}
