package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.Transient;

@Introspected
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails {
	private String name;
	private String email;
	private String password;

	@Transient
	private boolean valid = true;

	@Transient
	private String invalidReason;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getInvalidReason() {
		return invalidReason;
	}

	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}

	public boolean validate() {
		if (name == null || name.trim().length() <= 0) {
			setValid(false);
			setInvalidReason("Users name is not Valid");
		}

		if (email == null || email.trim().length() <= 0 || email.indexOf("@") <= 1) {
			setValid(false);
			setInvalidReason("Users name is not Valid");
		}

		if (password == null || password.trim().length() <= 0) {
			setValid(false);
			setInvalidReason("Password is not Valid");
		}

		return isValid();
	}
}
