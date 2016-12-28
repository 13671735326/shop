package com.java2.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.UserEntity;
import com.java2.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDTO> getUsers() {
		List<UserEntity> users = userRepository.getUsers();
		List<UserDTO> dtos = new ArrayList<>();
		for( UserEntity user:users){
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dtos.add(dto);
		}
		return dtos;
	}
	

	@Override
	public void addUser(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userRepository.addUser(userEntity);
	}

	public void addUser(UserEntity user) {
		userRepository.addUser(user);
	}

	public void removeUser(UserEntity user) {
		userRepository.removeUser(user);
	}

	public void updateStudent(UserEntity user) {
		userRepository.updateStudent(user);
	}

	public UserEntity findUser(int userId) {
		return userRepository.findUser(userId);

	}

	public List<UserEntity> getListUser() {
		return userRepository.getListUser();

	}
	public UserRepository getUserRepsitory() {
		return userRepository;
	}
	
	public void setUserRepsitory(UserRepository userRepsitory) {
		this.userRepository = userRepsitory;
	}
}
