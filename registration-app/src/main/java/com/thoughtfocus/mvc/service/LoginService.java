package com.thoughtfocus.mvc.service;

import com.thoughtfocus.mvc.dto.UserDTO;

public interface LoginService {
	public UserDTO authenticationUser(String username, String password);
}
