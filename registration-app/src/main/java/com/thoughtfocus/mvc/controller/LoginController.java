package com.thoughtfocus.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtfocus.mvc.dto.UserDTO;
import com.thoughtfocus.mvc.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.do")
	public ModelAndView loginUser(@RequestParam String username, @RequestParam String password) {
		ModelAndView view = new ModelAndView();
		UserDTO dto = loginService.authenticationUser(username, password);
		if (dto != null) {
			view.setViewName("home");
			view.addObject("status", dto);

		} else {
			view.setViewName("error");
			view.addObject("status", "login failed...");
		}
		return view;
	}
}
