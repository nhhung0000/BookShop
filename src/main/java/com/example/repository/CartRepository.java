package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, String> {

	public List<Cart> findByUserId(String id);
}
