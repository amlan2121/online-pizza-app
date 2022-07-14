package com.cg.onlinepizzaapp.onlinepizzaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
