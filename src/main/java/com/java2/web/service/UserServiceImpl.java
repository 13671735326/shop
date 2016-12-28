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
	private UserRepository userRepsitory;
	
	@Override
	public List<UserDTO> getUsers() {
		List<UserEntity> users = userRepsitory.getUsers();
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
		userRepsitory.addUser(userEntity);
	}

	public UserRepository getUserRepsitory() {
		return userRepsitory;
	}
	
	public void setUserRepsitory(UserRepository userRepsitory) {
		this.userRepsitory = userRepsitory;
	}

}
