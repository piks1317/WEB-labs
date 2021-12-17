package com.example.lab7.repositories.katia;

import com.example.lab7.models.katia.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutRepository extends JpaRepository<Rout, Integer> {
    Rout findByName(String name);
}
