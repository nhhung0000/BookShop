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

import com.example.dto.BookDto;
import com.example.util.Executable;

@Entity
@Table(name = "books")
public class Book extends AbstractEntity<BookDto, Book> implements Executable<BookDto> {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "image")
	private String image;

	@Column(name = "author")
	private String author;

	@ManyToMany
	@JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "price", columnDefinition = "LONG")
	private long price;

	@OneToMany(mappedBy = "book")
	private List<Cart> carts;

	public Book() {
		super();
	}

	public Book(String name, String code, String image, String author, String description, long price) {
		super();
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
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

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public BookDto toDto() {
		List<String> categoryStrings = new ArrayList<String>();
		BookDto bookDto = new BookDto(name, image, author, description, price);
		bookDto.setId(getId());
		bookDto.setCreatedDate(getCreatedDate());
		bookDto.setLastModifiedDate(getLastModifiedDate());
		for (Category category : categories) {
			categoryStrings.add(category.getName());
		}
		bookDto.setCategories(categoryStrings);
		return bookDto;
	}

	@Override
	public Book update(Book book) {
		name = book.name;
		code = book.code;
		image = book.image;
		author = book.author;
		description = book.description;
		price = book.price;
		return this;
	}

}
