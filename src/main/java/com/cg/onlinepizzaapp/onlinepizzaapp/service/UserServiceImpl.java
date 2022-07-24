package com.cg.onlinepizzaapp.onlinepizzaapp.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IUserRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.EmptyValuesException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.UserAlreadyExistsException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.UserNotFoundException;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepo;

	

	@Override
	public User addNewUser(User user) {
		
		if (user.getUserName() == null || user.getUserName().length() == 0)
			throw new EmptyValuesException("Username cannot be empty.");
		if (user.getUserPassword() == null || user.getUserPassword().length() == 0)
			throw new EmptyValuesException("Password cannot be empty.");
		if (userRepo.existsByUserName(user.getUserName()))
			throw new UserAlreadyExistsException("User already exists.");

		userRepo.save(user);
		return user;
	}

	 
		@Override
		public String signOut(User user) {
			// TODO Auto-generated method stub
			return "SignedOut Successfully";
		}
		
		@Override
		public User signIn(String userName,String userPassword) {
			Optional<User> signedUser=userRepo.findByUserNameAndUserPassword(userName, userPassword);
			if(signedUser.isPresent()) {
				return signedUser.get();
			}
			else {
				throw new UserNotFoundException("Not found");
			}
//			Optional<User> user=userRepo.findByUserNameAndUserPassword(userName,userPassword);
//			if(user.isEmpty()) {
//				throw new UserNotFoundException("User Not Found");
//				
//			}
//			else {
//				return "sign in sucessfully";
//				
//			}
		}


		@Override
		public User resetPassword(String oldPassword, String newPassword) {
			// TODO Auto-generated method stub
			Optional<User> op=userRepo.findByUserPassword(oldPassword);
			if(op.isEmpty()) {
				throw new UserNotFoundException("User Not Found");
			
			}
			else {
				op.get().setUserPassword(newPassword);
				return op.get();
				
			}
			
		}
	 


}