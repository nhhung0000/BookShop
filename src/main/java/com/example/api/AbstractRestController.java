package com.example.api;

import java.util.List;

public abstract class AbstractRestController<T> {

	public abstract List<T> getAll();

	public abstract T getById(String id);

	public abstract T save(T t);

	public abstract T update(T t);

	public abstract void delete(String id);

}
