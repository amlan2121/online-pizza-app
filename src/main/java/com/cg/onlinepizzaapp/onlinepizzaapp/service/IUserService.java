package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;

public interface IUserService {
	public User addNewUser(User user);
	public User signIn(User user);
	public User signOut(User user);
	public boolean forgotPassword(String oldPassword ,String newPassword);
	
}
