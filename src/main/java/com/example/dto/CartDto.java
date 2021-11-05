package com.example.dto;

import org.springframework.stereotype.Component;

import com.example.entity.Cart;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class CartDto extends AbstractDto<Cart> {

	@JsonProperty(access = Access.WRITE_ONLY)
	private String userId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String bookId;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String user;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String book;
	
	private int quantity;

	public CartDto() {
		super();
	}

	public CartDto(String userId, String bookId, int quantity) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDto [userId=" + userId + ", bookId=" + bookId + ", user=" + user + ", book=" + book + ", quantity="
				+ quantity + "]";
	}

	@Override
	public Cart toEntity() {
		return new Cart(quantity);
	}

}
