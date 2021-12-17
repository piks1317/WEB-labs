package com.example.lab7.repositories.julia;

import com.example.lab7.models.julia.Medecine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecineRepository extends JpaRepository<Medecine, Integer> {
    Medecine findByName(String name);
}
