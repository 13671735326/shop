package com.java2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.AddressDTO;
import com.java2.web.dtos.UserDTO;
import com.java2.web.service.AddressService;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<AddressDTO> getAddresses() {
		return addressService.getAddresses();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addAddress(@RequestBody AddressDTO addAddress) {
		addressService.addAddress(addAddress);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeAddress(@PathVariable int idAddress) {
		addressService.removeAddress(idAddress);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public void updateAddress(@RequestBody AddressDTO addAddress) {
		addressService.updateAddress(addAddress);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AddressDTO getAddress(@PathVariable int id) {
		return addressService.getAddress(id);
	}
}
