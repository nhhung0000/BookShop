package com.example.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class CategoryDto extends AbstractDto<Category> {

	@JsonProperty(access = Access.READ_ONLY)
	private String name;

	@JsonProperty(access = Access.READ_ONLY)
	private List<String> books;

	public CategoryDto() {
		super();
	}

	public CategoryDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "CategoryDto [name=" + name + "]";
	}

	@Override
	public Category toEntity() {
		return new Category(name);
	}

}
