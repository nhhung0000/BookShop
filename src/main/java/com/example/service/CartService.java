package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CartDto;
import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.util.Converter;
import com.example.util.Util;

@Service
public class CartService extends AbstractService<CartDto> {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private Converter<CartDto, Cart> converter;

	@Override
	public List<CartDto> getAll() {
		return converter.toDtos(cartRepository.findAll());
	}

	@Override
	public CartDto getById(String id) {
		Cart cart = cartRepository.findById(id).orElse(null);
		return cart != null ? cart.toDto() : new CartDto();
	}

	@Override
	public CartDto save(CartDto cartDto) {
		Cart cart = cartDto.toEntity();
		cart.setId("cart_" + Util.generateId());
		User user = userRepository.findById(cartDto.getUserId()).orElse(null);
		Book book = bookRepository.findById(cartDto.getBookId()).orElse(null);
		if (user != null && book != null) {
			for (CartDto cartDto2 : getByUserId(user.getId())) {
				if (book.getId().equals(cartDto2.getBookId())) {
					cartDto2.setQuantity(cartDto2.getQuantity()+cart.getQuantity());
					return update(cartDto2);
				}
			}
			cart.setUser(user);
			cart.setBook(book);
			return cartRepository.save(cart).toDto();
		}
		return new CartDto();
	}

	@Override
	public CartDto update(CartDto cartDto) {
		Cart cart = cartRepository.findById(cartDto.getId()).orElse(null);
		if (cart != null) {
			cart.update(cartDto.toEntity());
			return cartRepository.save(cart).toDto();
		} else {
			return new CartDto();
		}
	}

	@Override
	public void delete(String id) {
		cartRepository.deleteById(id);
	}

	public List<CartDto> getByUserId(String id) {
		return converter.toDtos(cartRepository.findByUserId(id));
	}

}
