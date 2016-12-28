package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.UserEntity;
import com.java2.web.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addUser(@RequestBody UserDTO user) {
		userService.addUser(user);
	}

	@RequestMapping(path = "removeUser/{id}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable int id) {
		userService.removeUser(id);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public UserDTO getUse(@PathVariable int userId) {
		return userService.getUser(userId);

	}

}
