package com.satya.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.satya.bean.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
	
    Person findByName(String username);
	
}
