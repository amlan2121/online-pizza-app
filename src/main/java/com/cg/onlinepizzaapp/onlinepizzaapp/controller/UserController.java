package com.cg.onlinepizzaapp.onlinepizzaapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	

	@PostMapping("/addnewuser")
	public ResponseEntity<User> signUp(@RequestBody User user) {

		return new ResponseEntity<User>(userService.addNewUser(user), HttpStatus.OK);
	}
	
//
	@GetMapping("/signIn/{userName}/{userPassword}")
	public User signIn(@PathVariable String userName,@PathVariable String userPassword) {
		return userService.signIn(userName,userPassword);
		
			
	}
	
	@GetMapping(value="/signOut")
	public String signOutUser(@RequestBody User user){
		return userService.signOut(user);
	}
	
	@PostMapping(value="/resetpassword/{oldPassword}/{newPassword}")
	public String resetPassword(String oldPassword,String newPassword) {
		userService.resetPassword(oldPassword, newPassword);
		return "password reset successfully";
	}
//	

}
