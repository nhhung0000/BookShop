package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.dto.CartDto;
import com.example.util.Executable;

@Entity
@Table(name = "carts")
public class Cart extends AbstractEntity<CartDto, Cart> implements Executable<CartDto> {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@Column(name = "quantity")
	private int quantity;

	public Cart() {
		super();
	}

	public Cart(int quantity) {
		super();
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
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
		return "Cart [quantity=" + quantity + "]";
	}

	@Override
	public CartDto toDto() {
		CartDto cartDto = new CartDto(user.getId(), book.getId(), quantity);
		cartDto.setId(getId());
		cartDto.setUser(user.getName());
		cartDto.setBook(book.getName());
		cartDto.setCreatedDate(getCreatedDate());
		cartDto.setLastModifiedDate(getLastModifiedDate());
		return cartDto;
	}

	@Override
	public Cart update(Cart cart) {
		quantity = cart.quantity;
		return this;
	}

}
