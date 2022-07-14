package com.cg.onlinepizzaapp.onlinepizzaapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;



@Repository
public interface ICoupanRepository extends JpaRepository<Coupan, Integer> {

}
