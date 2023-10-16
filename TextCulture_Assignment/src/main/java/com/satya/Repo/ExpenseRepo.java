package com.satya.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.bean.Expenses;
import com.satya.bean.Person;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses, Integer> {
	
	List<Expenses> findByPerson(Person person);
	
}


