package com.transverse.rbac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transverse.rbac.model.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
}
