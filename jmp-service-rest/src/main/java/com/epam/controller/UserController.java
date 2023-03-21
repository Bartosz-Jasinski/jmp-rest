package com.epam.controller;

import java.util.List;


import com.epam.model.UserRequestDto;
import com.epam.model.UserResponseDto;

public interface UserController {
	UserResponseDto createUser(UserRequestDto request);

	UserResponseDto updateUser(UserRequestDto request);

	void deleteUser(Long id);

	UserResponseDto getUser(Long id);

	List<UserResponseDto> getAllUser();
}
