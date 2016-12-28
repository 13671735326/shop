package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.UserEntity;

public interface UserService {

	public void addUser(UserDTO user);

	public void removeUser(int idUser);

	public void updateUser(UserDTO user);

	public List<UserDTO> getUsers();

	public UserDTO getUser(int idUser);

}
