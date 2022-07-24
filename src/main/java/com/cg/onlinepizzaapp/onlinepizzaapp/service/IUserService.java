package com.cg.onlinepizzaapp.onlinepizzaapp.service;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;

public interface IUserService {
	public User addNewUser(User user);
	public User signIn(String userName,String userPassword) ; 
	public String signOut(User user);
	public User resetPassword(String oldPassword ,String newPassword); 
//	
}