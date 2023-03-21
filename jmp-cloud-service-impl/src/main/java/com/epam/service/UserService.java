package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.controller.UserController;
import com.epam.model.UserRequestDto;
import com.epam.model.UserResponseDto;

@Service
@RestController
@RequestMapping("users")
public class UserService {
	private final UserController userController;

	@Autowired
	public UserService(UserController userController) {
		this.userController = userController;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public UserResponseDto createUser(@RequestBody UserRequestDto request) {
		return userController.createUser(request);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public UserResponseDto updateUser(@RequestBody UserRequestDto request) {
		return userController.updateUser(request);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userController.deleteUser(id);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public UserResponseDto getUser(@PathVariable("id") Long id) {
		return userController.getUser(id);
	}

	@GetMapping(produces = "application/json")
	public List<UserResponseDto> getAllUser() {
		return userController.getAllUser();
	}
}
