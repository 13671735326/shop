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
		for (UserEntity user : users) {
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

	@Override
	public void removeUser(int idUser) {
		userRepository.removeUser(idUser);
	}

	@Override
	public void updateUser(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userRepository.updateUser(userEntity);
	}

	@Override
	public UserDTO getUser(int idUser) {

		UserEntity user = userRepository.getUser(idUser);
		UserDTO dto = new UserDTO();

		dto.setId(user.getId());
		dto.setName(user.getName());
		return dto;
	}
}
