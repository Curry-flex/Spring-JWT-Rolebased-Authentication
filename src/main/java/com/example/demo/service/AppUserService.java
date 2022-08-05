package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import com.example.demo.repository.userRepository;

@Service
public class AppUserService {

	 @Autowired
	 private userRepository userDao;
	 
	 public List<User> getAllAppUser()
	 {
		 return (List<User>) userDao.findAll();
	 }
}
