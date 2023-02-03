package com.example.demo.dto;

public class UserDto {
private Integer userId;
	
	private String name;
	
	private String dob;
	
	
	private String gender;
	
	
	private String email;
	
	private String address;
	
	private Integer mobile;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public UserDto(Integer userId, String name, String dob, String gender, String email, String address,
			Integer mobile) {
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}

	public UserDto() {
		
	}
	

}
