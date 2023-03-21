package com.epam.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.model.User;
import com.epam.model.UserRequestDto;

@Component
public class UserRequestToUserConverter implements Converter<UserRequestDto, User> {
	@Override
	public User convert(UserRequestDto source) {
		return new User(source.getId(),
				source.getName(),
				source.getSurname(),
				LocalDate.parse(source.getBirthday()));
	}
}
