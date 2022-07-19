package com.cg.onlinepizzaapp.onlinepizzaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.IAdminService;



@RestController
@RequestMapping("/admins")
@Validated
	public class AdminController {
		@Autowired
		 IAdminService adminService;
		/*
		 * login
		 */
		@GetMapping("/signIn/{adminName}/{adminPassword}")
		public String signIn(@PathVariable String adminName,@PathVariable String adminPassword) {
			Admin admin1 = adminService.signIn(adminName,adminPassword);
			if(admin1!=null) return "SuccesfullSign";
			else return "InvalidPassword or Id,If a newadmin add your details and proceed";
			
			}

		/*
		 * adding user
		 */
		@PostMapping("/addNewAdmin")
		public ResponseEntity<Admin> add(@RequestBody Admin admin) {
			Admin admin1 = adminService.addNewAdmin(admin);
			return new ResponseEntity<>(admin1, HttpStatus.OK);
		}
		/*
		 * signOut user
		 */
		
		@PostMapping(value="/signOut")
		public void signOutAdmin(@RequestBody Admin admin){
			adminService.signOut(admin);
		
	}
		
		
}





