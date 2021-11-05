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

import com.example.dto.UserDto;
import com.example.service.UserService;

@RestController
public class UserRestController extends AbstractRestController<UserDto> {

	@Autowired
	private UserService userService;

	@Override
	@GetMapping(value = "/api/users")
	public List<UserDto> getAll() {
		return userService.getAll();
	}

	@Override
	@GetMapping(value = "/api/users/{id}")
	public UserDto getById(@PathVariable(value = "id") String id) {
		return userService.getById(id);
	}

	@Override
	@PostMapping(value = "/api/user")
	public UserDto save(@RequestBody UserDto userDto) {
		return userService.save(userDto);
	}

	@Override
	@PutMapping(value = "/api/user")
	public UserDto update(@RequestBody UserDto userDto) {
		return userService.update(userDto);
	}

	@Override
	@DeleteMapping(value = "/api/users/{id}")
	public void delete(@PathVariable(value = "id") String id) {
		userService.delete(id);
	}

}
