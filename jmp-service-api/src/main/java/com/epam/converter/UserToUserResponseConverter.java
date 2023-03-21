package com.epam.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.model.User;
import com.epam.model.UserResponseDto;

@Component
public class UserToUserResponseConverter implements Converter<User, UserResponseDto> {
	@Override
	public UserResponseDto convert(User source) {
		return new UserResponseDto(source.getId(),
				source.getName(),
				source.getSurname(),
				source.getBirthday().toString());
	}
}
