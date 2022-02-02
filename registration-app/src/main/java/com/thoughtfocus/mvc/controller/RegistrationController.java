package com.thoughtfocus.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtfocus.mvc.dto.UserDTO;
import com.thoughtfocus.mvc.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	public RegistrationController() {
		System.out.println(this.getClass().getCanonicalName());
	}

	@RequestMapping("/reg.do")
	public ModelAndView registerUser(UserDTO user) {
		ModelAndView view = new ModelAndView();

		try {
			boolean saveStatus = registrationService.validateAndsaveUser(user);

			if (saveStatus) {
				view.setViewName("login");
				view.addObject("status", "Registration successful...");
			} else {
				view.setViewName("error");
				view.addObject("status", "registration failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return view;
	}

	@RequestMapping("/log.do")
	public ModelAndView doLogin() {
		return new ModelAndView("login", "status", "login page...");
	}

	@RequestMapping("/del.do")
	public ModelAndView deleteUser(@RequestParam String username) {
		ModelAndView view = new ModelAndView();

		try {
			boolean deleteStatus = registrationService.validateAndDeleteUserByName(username);

			if (deleteStatus) {
				view.setViewName("success");
				view.addObject("status", "Deleted successful...");
			} else {
				view.setViewName("error");
				view.addObject("status", "Unable to delete the user,please enter valid name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return view;
	}

	@RequestMapping("/update.do")
	public ModelAndView updateUser(@RequestParam String username, @RequestParam long mobilenumber,
			@RequestParam double age) {
		ModelAndView view = new ModelAndView();

		try {
			boolean updatedUser = registrationService.validateAndUpdate(username, mobilenumber, age);

			if (updatedUser) {
				view.setViewName("success");
				view.addObject("status", "updated user successfully");
			} else {
				view.setViewName("error");
				view.addObject("status", "Unable to update the user,please enter valid details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return view;
	}
}
