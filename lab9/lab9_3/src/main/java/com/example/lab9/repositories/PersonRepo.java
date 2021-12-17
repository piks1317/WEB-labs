package com.example.lab9.repositories;

import com.example.lab9.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person findPersonByEmail(String email);
}
