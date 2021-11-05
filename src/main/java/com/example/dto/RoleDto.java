package com.example.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class RoleDto extends AbstractDto<Role> {

	@JsonProperty(access = Access.READ_ONLY)
	private String name;

	@JsonProperty(access = Access.READ_ONLY)
	private List<String> users;

	public RoleDto() {
		super();
	}

	public RoleDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "RoleDto [name=" + name + "]";
	}

	@Override
	public Role toEntity() {
		return new Role(name);
	}
}
