package com.example.lab7.repositories.katia;

import com.example.lab7.models.katia.Shedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SheduleRepository extends JpaRepository<Shedule, Integer> {
    Shedule findByRouteId(Integer id);
}
