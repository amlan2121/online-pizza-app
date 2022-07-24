package com.cg.onlinepizzaapp.onlinepizzaapp.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Boolean existsByUserName(String userName);
	Optional<User> findByUserNameAndUserPassword(String userName,String userPassword);
	Optional<User> findByUserPassword(String oldPassword);
}