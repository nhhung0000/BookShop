package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.dto.RoleDto;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity<RoleDto, Role> {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

	@Override
	public RoleDto toDto() {
		RoleDto roleDto = new RoleDto(name);
		roleDto.setId(getId());
		return roleDto;
	}

	@Override
	public Role update(Role t) {
		return null;
	}

}
