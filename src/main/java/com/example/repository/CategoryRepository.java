package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {

	public Category findByName(String name);
}
