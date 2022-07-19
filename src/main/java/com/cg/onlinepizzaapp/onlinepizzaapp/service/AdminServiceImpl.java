package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IAdminRepository;


@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminRepository adminRepository;
	/*
	 * login
	 */
	public Admin signIn(String adminName, String adminPassword) {
		Admin signedAdmin = adminRepository.signIn(adminName, adminPassword);
		if (signedAdmin != null) {
			return signedAdmin;
		} else {
			return new Admin();
		}
	}
	/*
	 * adding user
	 */
	public Admin addNewAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}
	
			/*
	 * logout
	 */
	public String signOut(Admin admin) {

		return "SignedOut Successfully";

	}
		
	}
			

