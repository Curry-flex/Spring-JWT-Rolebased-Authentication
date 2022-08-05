package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ChangePasswordDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import com.example.demo.repository.userRepository;
import com.example.demo.service.AppUserService;
import com.example.demo.service.UserService;

@RestController
@Service
public class UserController {
	
    @Autowired
    private UserService userService;
    @Autowired
    private AppUserService appUserService;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Autowired
    private userRepository userDao;
    
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"api/realbus/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    
    @GetMapping("api/realbus/users")
    
    public List<User> getAllUsers()
    {
    	return appUserService.getAllAppUser();
    }
    
    @GetMapping("api/realbus/user/{id}")
    public User getUserByID(@PathVariable int id)
    {
    	return userService.getUser(id);
    }
    

    @DeleteMapping("api/realbus/user/{id}")
    public void deleteUser(@PathVariable int id)
    {
    	userService.deleteUser(id);
    }
    
    
    @PostMapping("api/realbus/rp")
    public String changePaasword(@RequestBody ChangePasswordDTO changePasswordDTO)
    {
    	
    	//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	//System.out.println(changePasswordDTO.getNewPassword());
    	String oldPassword = changePasswordDTO.getOldPaaword();
    	String existingPassword=userDao.getUserPaasword(1);
    	
    	System.out.println(getEncodedPassword(oldPassword));
    	System.out.println(existingPassword);
    	
    	if(passwordEncoder.matches( oldPassword, existingPassword)) {
    		
    		if(changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword()))
    		{
    			User user = userDao.findById(changePasswordDTO.getUserID()).orElseThrow();
    			System.out.println(changePasswordDTO.getNewPassword());
    			user.setUserPassword(getEncodedPassword(changePasswordDTO.getNewPassword()));
    			userDao.save(user);
    			//System.out.println("success");
    		}
    		else {
    			return "101";
    			
    		}
    	   }
    	  else {
    		return "102";
    	}    
    	
    	return "";
    	
    }
    
    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
      
//    @GetMapping("api/realbus/account-list")
//    public List<String> getAccountList()
//    {
//    	
//    }
    

}
