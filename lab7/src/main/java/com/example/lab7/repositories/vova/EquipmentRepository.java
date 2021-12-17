package com.example.lab7.repositories.vova;

import com.example.lab7.models.vova.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    Equipment findByName(String name);
}
