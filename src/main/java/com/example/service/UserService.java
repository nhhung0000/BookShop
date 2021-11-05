package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.util.Converter;
import com.example.util.Util;

@Service
public class UserService extends AbstractService<UserDto> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private Converter<UserDto, User> converter;

	@Override
	public List<UserDto> getAll() {
		return converter.toDtos(userRepository.findAll());
	}

	@Override
	public UserDto getById(String id) {
		User user = userRepository.findById(id).orElse(null);
		return user != null ? user.toDto() : new UserDto();
	}

	@Override
	public UserDto save(UserDto userDto) {
		User user = userDto.toEntity();
		user.setId("user_" + Util.generateId());
		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_MEMBER")));
		return userRepository.save(user).toDto();
	}

	public UserDto login(String username, String password) {
		List<UserDto> userDtos = getAll();
		for (UserDto userDto : userDtos) {
			if (username.equals(userDto.getUsername()) && password.equals(userDto.getPassword())) {
				return userDto;
			}
		}
		return null;
	}
	
	@Override
	public UserDto update(UserDto userDto) {
		User user = userRepository.findById(userDto.getId()).orElse(null);
		if (user != null) {
			user.update(userDto.toEntity());
			return userRepository.save(user).toDto();
		} else {
			return new UserDto();
		}
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

}
