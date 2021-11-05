package com.example.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class UserDto extends AbstractDto<User> {

	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private String name;
	private String image;
	private String phone;
	private String address;

	@JsonProperty(access = Access.READ_ONLY)
	private List<String> roles;

	public UserDto() {
		super();
	}

	public UserDto(String username, String password, String name, String image, String phone, String address,
			String roleId) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.image = image;
		this.phone = phone;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", name=" + name + ", image=" + image
				+ ", phone=" + phone + ", address=" + address + "]";
	}

	@Override
	public User toEntity() {
		return new User(username, password, name, image, phone, address);
	}

}
