package com.example.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class BookDto extends AbstractDto<Book> {

	private String name;
	private String image;
	private String author;

	@JsonProperty(access = Access.READ_ONLY)
	private List<String> categories;

	private String description;
	private long price;

	@JsonProperty(access = Access.WRITE_ONLY)
	private List<String> categoryIds;

	public BookDto() {
		super();
	}

	public BookDto(String name, String image, String author, String description, long price) {
		super();
		this.name = name;
		this.image = image;
		this.author = author;
		this.description = description;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public List<String> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<String> categoryIds) {
		this.categoryIds = categoryIds;
	}

	@Override
	public String toString() {
		return "BookDto [name=" + name + ", image=" + image + ", author=" + author + ", categories=" + categories
				+ ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public Book toEntity() {
		return new Book(name, name, image, author, description, price);
	}

}
