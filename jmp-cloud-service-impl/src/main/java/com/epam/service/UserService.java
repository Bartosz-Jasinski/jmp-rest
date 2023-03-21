package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.controller.UserController;
import com.epam.model.UserResponseDto;

@Service
@RestController
@RequestMapping("users")
public class UserService {
	@Autowired
	private UserController userController;

	@GetMapping(value = "/all", produces = "application/json")
	public void getAllUser(){
		List<UserResponseDto> allUser = userController.getAllUser();
	}
}
