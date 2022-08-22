package com.alternance.test.service;

import java.util.List;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.User;

public interface IUserService {

	public MessageResponse ajoutUser(User user);
	
	public MessageResponse deleteUser(Long id);
	
	public MessageResponse updateUser(User user);
		
	public List<User> getUsers ();
	
	public User getUserById(Long id);
}
