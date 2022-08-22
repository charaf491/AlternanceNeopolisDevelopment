package com.alternance.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternance.test.dto.MessageResponse;
import com.alternance.test.entity.User;
import com.alternance.test.service.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService us;
	
	@GetMapping("")
	public List<User> getUsers() {return us.getUsers() ; }
	
	@GetMapping("getUser/{id}")
	public User getUserById(@PathVariable Long id ) {return us.getUserById(id);}
	
	@PostMapping("addUser")
	public MessageResponse addUser(@RequestBody User user) {return us.ajoutUser(user);}
	
	@PutMapping("modifyUser")
	public MessageResponse updateUser(@RequestBody User user) {return us.updateUser(user);}
	
	@DeleteMapping("deleteUser/{id}")
	public MessageResponse deleteUser (@PathVariable Long id ) {return us.deleteUser(id);} 
}
