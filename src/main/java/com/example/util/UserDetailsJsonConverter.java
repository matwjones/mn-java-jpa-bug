package com.example.util;

import com.example.model.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class UserDetailsJsonConverter implements AttributeConverter<UserDetails, String> {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(UserDetails attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public UserDetails convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, UserDetails.class);
		} catch (IOException e) {
			return null;
		}
	}
}
