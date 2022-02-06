package com.thoughtfocus.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.exception.NullEmailAndPasswordException;
import com.thoughtfocus.project.service.LoginService;

@RestController
public class LoginController {
	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	DetailsEntity login(@RequestParam String email, @RequestParam String password) {
		DetailsEntity entity = null;
		try {
			if (email != "" && email != null && password != null && password != "") {
				entity = loginService.loginUser(email, password);
				// logger.info(entity.toString());
			} else {
				throw new NullEmailAndPasswordException("Enter valid email to get details");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return entity;
	}
}
