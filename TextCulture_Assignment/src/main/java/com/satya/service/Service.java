package com.satya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.satya.Repo.ExpenseRepo;
import com.satya.bean.Expenses;
import com.satya.bean.Person;


@org.springframework.stereotype.Service
public class Service {
	
	
	@Autowired
	ExpenseRepo expenseRepo;
	
	
	//add the expense 
	public Expenses addExpenses(@RequestBody Expenses expense) {
        return expenseRepo.save(expense);
    }
    
	
	public List<Expenses> getUserExpenses(Person user) {
        return expenseRepo.findByPerson(user);
    }

    public double calculateTotalExpenses(Person user) {
        List<Expenses> expenses = getUserExpenses(user);
        double total = expenses.stream().mapToDouble(Expenses::getAmount).sum();
        return total;
    }
}
