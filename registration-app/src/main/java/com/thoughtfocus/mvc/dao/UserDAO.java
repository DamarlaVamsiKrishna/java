package com.thoughtfocus.mvc.dao;

import com.thoughtfocus.mvc.dto.UserDTO;

public interface UserDAO {
	public boolean saveUser(UserDTO user);

	public UserDTO getByUserNameAndPaaword(String username, String password);

	public boolean deleteUserByName(String name);

	public boolean updateUserByName(String username,long mobilenumber, double age);
}
