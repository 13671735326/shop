package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.UserDTO;
import com.java2.web.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="",method = RequestMethod.GET)
	public List<UserDTO> getUsers(){
		return userService.getUsers();
	}
	
	@RequestMapping(path ="addUser",method = RequestMethod.POST)
	public void addUser(UserDTO user){
		userService.addUser(user);
	}

}
