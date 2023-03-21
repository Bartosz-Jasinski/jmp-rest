package com.epam.service;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.epam.controller.UserController;
import com.epam.model.User;
import com.epam.model.UserRequestDto;
import com.epam.model.UserResponseDto;
import com.epam.repo.UserRepository;

@Service
public class UserControllerImpl implements UserController {

	private final UserRepository userRepository;
	private final ConversionService conversionService;

	@Autowired
	public UserControllerImpl(UserRepository userRepository, ConversionService conversionService) {
		this.userRepository = userRepository;
		this.conversionService = conversionService;
	}

	@Override
	public UserResponseDto createUser(UserRequestDto request) {
		return Optional.ofNullable(conversionService.convert(request, User.class))
				.filter(user -> Objects.isNull(user.getId()))
				.map(userRepository::save)
				.map(user -> conversionService.convert(user, UserResponseDto.class))
				.orElseThrow(() -> new RuntimeException("Error during creating User."));
	}

	@Override
	public UserResponseDto updateUser(UserRequestDto request) {
		return Optional.ofNullable(conversionService.convert(request, User.class))
				.filter(user -> !Objects.isNull(user.getId()))
				.map(userRepository::save)
				.map(user -> conversionService.convert(user, UserResponseDto.class))
				.orElseThrow(() -> new RuntimeException("Error during updating User."));
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserResponseDto getUser(Long id) {
		return userRepository.findById(id)
				.map(user -> conversionService.convert(user, UserResponseDto.class))
				.orElseThrow(() -> new InvalidParameterException("User with id " + id + " not found."));
	}

	@Override
	public List<UserResponseDto> getAllUser() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(user -> conversionService.convert(user, UserResponseDto.class))
				.toList();
	}
}
