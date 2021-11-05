package com.example.service;

import java.util.List;

public abstract class AbstractService<T> {

	public abstract List<T> getAll();

	public abstract T getById(String id);

	public abstract T save(T t);

	public abstract T update(T t);

	public abstract void delete(String id);

}
