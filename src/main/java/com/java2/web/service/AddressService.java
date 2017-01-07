package com.java2.web.service;

import java.util.List;

import com.java2.web.dtos.AddressDTO;

public interface AddressService {

	public void addAddress(AddressDTO address);

	public void removeAddress(int idAddress);

	public void updateAddress(AddressDTO address);

	public List<AddressDTO> getAddresses();

	public AddressDTO getAddress(int idAddress);
}
