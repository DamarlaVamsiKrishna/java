package com.thoughtfocus.mvc.service;

import com.thoughtfocus.mvc.dto.UserDTO;

public interface RegistrationService {
	public boolean validateAndsaveUser(UserDTO user);

	public boolean  validateAndDeleteUserByName(String username);

	public boolean validateAndUpdate(String username,long mobilenumber, double age);
}
