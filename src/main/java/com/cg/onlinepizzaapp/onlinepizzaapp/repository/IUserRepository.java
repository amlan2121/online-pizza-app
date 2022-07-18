package com.cg.onlinepizzaapp.onlinepizzaapp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserIdAndUserPassword(int userId,String userPassword);
	Optional<User> findByuserPassword(String oldPassword);
}