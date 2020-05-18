package com.example.model;

import com.example.util.UserDetailsJsonConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Introspected
@Table(name = "registrationrequests")
public class RegistrationRequest {

	@Id
	@GeneratedValue
	private Long id;

	private String key;

	@Convert(converter = UserDetailsJsonConverter.class)
	private UserDetails userDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
