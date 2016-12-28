package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.UserEntity;
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
	
//	@RequestMapping(path ="addUser",method = RequestMethod.POST)
//	public void addUser(UserDTO user){
//		userService.addUser(user);
//	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(UserEntity user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/removeUser", method = RequestMethod.DELETE)
	public void removeUser(UserEntity user) {
		userService.removeUser(user);
	}

	@RequestMapping(value = "/updateStudent")
	public void updateStudent(UserEntity user) {
		userService.updateStudent(user);
	}

	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	public UserEntity findUser(int userId) {
		return userService.findUser(userId);

	}

	@RequestMapping(value = "/getListUser", method = RequestMethod.GET)
	public List<UserEntity> getListUser() {
		return userService.getListUser();

	}
}
