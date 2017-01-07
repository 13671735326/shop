package com.java2.web.dtos;

import java.util.Date;
import java.util.List;

import com.java2.web.entity.AddressEntity;

public class OrdersDTO {
	private int id;
	private Date createDate;
	private String address;
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
