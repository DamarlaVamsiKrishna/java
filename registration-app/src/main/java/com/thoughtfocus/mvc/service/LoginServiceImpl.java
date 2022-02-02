package com.thoughtfocus.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thoughtfocus.mvc.dao.UserDAO;
import com.thoughtfocus.mvc.dto.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO dao;
	
	
//	@Override
//	public boolean authenticationUser(String username, String password) {
//		RestTemplate template = new RestTemplate();
//		UserDTO user = template.getForObject("http://localhost:8088/spring-rest-producer/rest/users/" + username + "/" + password, UserDTO.class);
//		if(user!=null) {
//			System.out.println(user);
//			return true;
//		}
//		return false;
//	}

	@Override
	public UserDTO authenticationUser(String username, String password) {
		UserDTO dto=null;
		if (username != null && password != null) {
			return dao.getByUserNameAndPaaword(username, password);
		}
		return dto;
	}

}
