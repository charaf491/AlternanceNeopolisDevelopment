package com.alternance.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.User;
import com.alternance.test.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository ur;
	
	@Override
	@Transactional
	public MessageResponse ajoutUser(User user) {
		boolean exist = ur.existsByUsername(user.getUsername());
		if (exist) {
			return new MessageResponse(false, "Attention", "Username existe déjà!!");
		}

		ur.save(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public MessageResponse deleteUser(Long id) {
		User user = getUserById(id);
		if (user == null) {
			return new MessageResponse(false, "Attention", "Utilisteaur introuvable!!");
		}
		
		ur.delete(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public MessageResponse updateUser(User user) {
		User us = getUserById(user.getId());
		if (us == null) {
			return new MessageResponse(false, "Attention", "Utilisteaur introuvable!!");
		}
		
		boolean exist = ur.existsByUsername(user.getUsername());
		if (exist) {
			return new MessageResponse(false, "Attention", "Username existe déjà!!");
		}

		ur.save(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return ur.findAll();
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		return ur.findById(id).orElse(null);
	}
}
