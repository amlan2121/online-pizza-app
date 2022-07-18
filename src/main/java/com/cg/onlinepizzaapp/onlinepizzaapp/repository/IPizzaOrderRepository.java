package com.cg.onlinepizzaapp.onlinepizzaapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;

@Repository
public interface IPizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{

	List<PizzaOrder> findByorderDate(LocalDate date);
	
	public static String calculateTotal(String size, double quantity) {
		if(size.equals("SMALL")) {
			double val=quantity*250;
			String str=String.valueOf(val);
				return str;
			} 
			if(size.equals("MEDIUM")) {
				double val=quantity*450;
				String str=String.valueOf(val);
					return str;
			}
			if(size.equals("LARGE")) {
				double val=quantity*550;
				String str=String.valueOf(val);
					return str;
			}
			else
				return "InvalidSize";
	}

}
