package com.java2.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.dtos.AddressDTO;
import com.java2.web.entity.AddressEntity;
import com.java2.web.repository.AddressRepository;
import com.java2.web.service.AddressService;

@Service
public class AddressServiceImp implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void addAddress(AddressDTO address) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress(address.getAddress());
		addressEntity.setDefault(address.isDefault());
		addressEntity.setUserEntity(address.getUserEntity());
		addressRepository.addAddress(addressEntity);

	}

	@Override
	public void removeAddress(int idAddress) {
		addressRepository.removeAddress(idAddress);
	}

	@Override
	public void updateAddress(AddressDTO address) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress(address.getAddress());
		addressEntity.setDefault(address.isDefault());
		addressEntity.setUserEntity(address.getUserEntity());
		
		addressRepository.updateAddress(addressEntity);
	}

	@Override
	public List<AddressDTO> getAddresses() {
		List<AddressEntity> addresses = addressRepository.getAddresses();
		List<AddressDTO> dtos = new ArrayList<>();
		for (AddressEntity address : addresses) {
			AddressDTO dto = new AddressDTO();
			dto.setId(address.getId());
			dto.setAddress(address.getAddress());
			dto.setDefault(address.isDefault());
			dto.setUserEntity(address.getUserEntity());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public AddressDTO getAddress(int idAddress) {
		AddressEntity address = addressRepository.getAddress(idAddress);
		AddressDTO dto = new AddressDTO();
		dto.setId(address.getId());
		dto.setAddress(address.getAddress());
		dto.setDefault(address.isDefault());
		dto.setUserEntity(address.getUserEntity());
		return dto;
	}

}
