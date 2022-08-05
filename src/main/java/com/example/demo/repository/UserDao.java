package com.example.demo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
//	User findByUserName(String userName);
//	
//	@Query("select userPassword from sp_users u where u.id=1?")
//	String getUserPaasword(int id);
}
