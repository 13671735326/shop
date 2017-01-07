package com.java2.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.UserDTO;
import com.java2.web.entity.Admin;
import com.java2.web.entity.UserEntity;
import com.java2.web.repository.UserRepository;
import com.java2.web.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setLoginName(user.getLoginName());
		userEntity.setNickName(user.getNickName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setAddresses(user.getAddresses());
		userRepository.addUser(userEntity);

	}

	@Override
	public void removeUser(int idUser) {
		userRepository.removeUser(idUser);
	}

	@Override
	public void updateUser(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setLoginName(user.getLoginName());
		userEntity.setNickName(user.getNickName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setAddresses(user.getAddresses());
		userRepository.updateUser(userEntity);
	}

	@Override
	public List<UserDTO> getUsers() {
		List<UserEntity> users = userRepository.getUsers();
		List<UserDTO> dtos = new ArrayList<>();
		for (UserEntity user : users) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setLoginName(user.getLoginName());
			dto.setNickName(user.getNickName());
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			dto.setAddresses(user.getAddresses());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UserDTO getUser(int idUser) {
		UserEntity user = userRepository.getUser(idUser);
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setLoginName(user.getLoginName());
		dto.setNickName(user.getNickName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAddresses(user.getAddresses());
		return dto;
	}
	
	@Override
	public boolean isUserCreditialValid(String name , String password) {
//		
//		boolean result = false;
//		Admin admin  = new Admin();
//			if((admin.getAdmin()==name)&&(admin.getPassword() ==password)) { 
//				result = true;
//			}else{
//			}
//			
//		return result;
		boolean result = true;
		List<UserEntity> users = userRepository.getUsers();
		for (UserEntity userEntity : users) {
			if((userEntity.getLoginName()==name)&&(userEntity.getPassword() ==password)) { 
				result = false;
			}
		}
		return result;
	}
}
