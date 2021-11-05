package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.dto.UserDto;
import com.example.util.Executable;

@Entity
@Table(name = "users")
public class User extends AbstractEntity<UserDto, User> implements Executable<UserDto> {

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	@OneToMany(mappedBy = "user")
	private List<Cart> carts;

	public User() {
		super();
	}

	public User(String username, String password, String name, String image, String phone, String address) {
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", image=" + image
				+ ", phone=" + phone + ", address=" + address + "]";
	}

	@Override
	public UserDto toDto() {
		List<String> roleStrings = new ArrayList<String>();
		UserDto userDto = new UserDto(username, password, name, image, phone, address, address);
		userDto.setId(getId());
		userDto.setCreatedDate(getCreatedDate());
		userDto.setLastModifiedDate(getLastModifiedDate());
		for (Role role : roles) {
			roleStrings.add(role.getName());
		}
		userDto.setRoles(roleStrings);
		return userDto;
	}

	@Override
	public User update(User user) {
		username = user.username;
		password = user.password;
		name = user.name;
		image = user.image;
		phone = user.phone;
		address = user.address;
		return this;
	}

}
