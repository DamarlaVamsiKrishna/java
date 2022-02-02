package com.thoughtfocus.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.mvc.dao.UserDAO;
import com.thoughtfocus.mvc.dto.UserDTO;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserDAO dao;

	Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Override
	public boolean validateAndsaveUser(UserDTO user) {

		if (user.getPassword().equals(user.getConfirmpassword())) {
			logger.info(user.toString());
			return dao.saveUser(user);
		}
		return false;
	}

	@Override
	public boolean validateAndDeleteUserByName(String username) {
		if (username != null) {
			logger.info(username);
			return dao.deleteUserByName(username);
		}
		return false;
	}

	@Override
	public boolean validateAndUpdate(String username, long mobilenumber, double age) {
		if (age != 0 && mobilenumber >= 999999 && username != null) {
			logger.info("username : ", username.toString());
			return dao.updateUserByName(username, mobilenumber, age);
		}
		return false;
	}
}
