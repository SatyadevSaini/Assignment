package com.satya.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satya.Repo.PersonRepo;
import com.satya.bean.Expenses;
import com.satya.bean.Person;
import com.satya.service.Service;

@RestController
public class Controller {
	
	@Autowired
	Service service;
	
	@Autowired
	PersonRepo personRepo;

	@PostMapping("/addExpense")
	public  Expenses addExpense(@RequestBody Expenses expenses) {
		return service.addExpenses(expenses);
	}
	
	 @GetMapping("/getPrice")
	    public double calculateClaims(@RequestParam String name) {
	        Person user = personRepo.findByName(name);
	        if (user == null) {
	            return 0.0;
	        }

	        double total = service.calculateTotalExpenses(user);
	        System.out.println("Total"+total);
	        return total;
	        
	    }
}
  