package com.epam.service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.controller.UserController;
import com.epam.model.UserRequestDto;
import com.epam.model.UserResponseDto;
import com.epam.repo.UserRepository;

@Service
public class UserControllerImpl implements UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserControllerImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponseDto createUser(UserRequestDto request) {
		return null;
	}

	@Override
	public UserResponseDto updateUser(UserRequestDto request) {
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserResponseDto getUser(Long id) {
		return userRepository.findById(id)
				.map(user -> new UserResponseDto(user.getId(),
						user.getName(),
						user.getSurname(),
						user.getBirthday().toString()))
				.orElseThrow(() -> new InvalidParameterException("User with id " + id + " not found."));
	}

	@Override
	public List<UserResponseDto> getAllUser() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(user -> new UserResponseDto(user.getId(),
						user.getName(),
						user.getSurname(),
						user.getBirthday().toString())
				).toList();
	}
}
