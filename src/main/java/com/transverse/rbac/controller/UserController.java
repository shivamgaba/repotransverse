package com.transverse.rbac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transverse.rbac.model.User;
import com.transverse.rbac.model.UserDto;
import com.transverse.rbac.service.UserService;

@RestController
public class UserController {

	@Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public User patchUser(@PathVariable(value= "id") Long id, @RequestBody UserDto user) {
    	User usero = userService.patchUser(id, user);
    	return usero;
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

}
