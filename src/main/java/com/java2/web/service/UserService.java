package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.UserDTO;

public interface UserService {
	
	public List<UserDTO> getUsers();
	public void addUser(UserDTO user);
	
}
