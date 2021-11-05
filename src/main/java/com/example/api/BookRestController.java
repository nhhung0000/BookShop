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

import com.example.dto.BookDto;
import com.example.service.BookService;

@RestController
public class BookRestController extends AbstractRestController<BookDto> {

	@Autowired
	private BookService bookService;
	
	@Override
	@GetMapping(value = "/api/books")
	public List<BookDto> getAll() {
		return bookService.getAll();
	}

	@Override
	@GetMapping(value = "/api/books/{id}")
	public BookDto getById(@PathVariable(value = "id") String id) {
		return bookService.getById(id);
	}

	@Override
	@PostMapping(value = "/api/book")
	public BookDto save(@RequestBody BookDto bookDto) {
		return bookService.save(bookDto);
	}

	@Override
	@PutMapping(value = "/api/book")
	public BookDto update(@RequestBody BookDto bookDto) {
		return bookService.update(bookDto);
	}

	@Override
	@DeleteMapping(value = "/api/books/{id}")
	public void delete(@PathVariable(value = "id") String id) {
		bookService.delete(id);
	}

}
