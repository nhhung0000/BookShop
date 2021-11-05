package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

	public Role findByName(String name);

}
