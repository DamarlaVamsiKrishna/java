package com.thoughtfocus.project.service;

import com.thoughtfocus.project.entity.DetailsEntity;

public interface LoginService {
	public DetailsEntity loginUser(String email, String password);
}
