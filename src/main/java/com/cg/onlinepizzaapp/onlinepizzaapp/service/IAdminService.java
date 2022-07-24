package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;

public interface IAdminService {

	public Admin  addNewAdmin(Admin admin);
	public Admin signIn(String adminName, String adminPassword);
	public String  signOut(Admin admin);

	
	
}
