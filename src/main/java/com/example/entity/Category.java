package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.dto.CategoryDto;

@Entity
@Table(name = "categories")
public class Category extends AbstractEntity<CategoryDto, Category> {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "categories")
	private List<Book> books;

	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public CategoryDto toDto() {
		CategoryDto categoryDto = new CategoryDto(name);
		List<String> bookStrings = new ArrayList<String>();
		if (books != null) {
			for (Book book : books) {
				bookStrings.add(book.getName());
			}
		}
		categoryDto.setBooks(bookStrings);
		return categoryDto;
	}

	@Override
	public Category update(Category category) {
		name = category.name;
		return this;
	}

}
