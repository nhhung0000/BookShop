package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.BookDto;
import com.example.entity.Book;
import com.example.entity.Category;
import com.example.repository.BookRepository;
import com.example.repository.CategoryRepository;
import com.example.util.Converter;
import com.example.util.Util;

@Service
public class BookService extends AbstractService<BookDto> {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private Converter<BookDto, Book> converter;

	@Override
	public List<BookDto> getAll() {
		return converter.toDtos(bookRepository.findAll());
	}

	@Override
	public BookDto getById(String id) {
		Book book = bookRepository.findById(id).orElse(null);
		return book != null ? book.toDto() : new BookDto();
	}

	@Override
	public BookDto save(BookDto bookDto) {
		Book book = bookDto.toEntity();
		book.setId("book_" + Util.generateId());
		List<Category> categories = new ArrayList<Category>();
		for (String id : bookDto.getCategoryIds()) {
			Category category = categoryRepository.findById(id).orElse(null);
			categories.add(category != null ? category : null);
		}
		book.setCategories(categories);
		return bookRepository.save(book).toDto();
	}

	@Override
	public BookDto update(BookDto bookDto) {
		Book book = bookRepository.findById(bookDto.getId()).orElse(null);
		if (book != null) {
			book.update(bookDto.toEntity());
			return bookRepository.save(book).toDto();
		} else {
			return new BookDto();
		}
	}

	@Override
	public void delete(String id) {
		bookRepository.deleteById(id);
	}

}
