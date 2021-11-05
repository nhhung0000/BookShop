package com.example.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Converter<D, E extends Executable<D>> {

	public List<D> toDtos(Iterable<E> es) {
		List<D> ds = new ArrayList<D>();
		for (E e : es) {
			ds.add((D) e.toDto());
		}
		return ds;
	}

}
