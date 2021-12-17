package com.example.lab7.repositories.vova;

import com.example.lab7.models.vova.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindRepository extends JpaRepository<Kind, Integer> {
}
