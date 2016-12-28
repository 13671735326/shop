package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.UserEntity;

public interface UserService {
	
	public List<UserDTO> getUsers();
	public void addUser(UserDTO user);
	public void addUser(UserEntity user);

	public void removeUser(UserEntity user);

	public void updateStudent(UserEntity user);

	public UserEntity findUser(int userId);

	public List<UserEntity> getListUser();
	
}
