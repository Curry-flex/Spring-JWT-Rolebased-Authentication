package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{

      User findByUserName(String userName);
	
	@Query("select userPassword from User u  where u.id=?1")
	String getUserPaasword(int id);
}
