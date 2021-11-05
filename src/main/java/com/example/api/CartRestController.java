package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CartDto;
import com.example.service.CartService;

@RestController
public class CartRestController extends AbstractRestController<CartDto> {

	@Autowired
	private CartService cartService;
	
	@Override
	@GetMapping(value = "/api/carts")
	public List<CartDto> getAll() {
		return cartService.getAll();
	}

	@Override
	@GetMapping(value = "/api/carts/{id}")
	public CartDto getById(@PathVariable(value = "id") String id) {
		return cartService.getById(id);
	}

	@Override
	@PostMapping(value = "/api/cart")
	public CartDto save(@RequestBody CartDto cartDto) {
		return cartService.save(cartDto);
	}

	@Override
	@PutMapping(value = "/api/cart")
	public CartDto update(@RequestBody CartDto cartDto) {
		return cartService.update(cartDto);
	}

	@Override
	@DeleteMapping(value = "/api/carts/{id}")
	public void delete(@PathVariable(value = "id") String id) {
		cartService.delete(id);
	}

}
