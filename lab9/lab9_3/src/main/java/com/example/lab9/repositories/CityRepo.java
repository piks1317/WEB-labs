package com.example.lab9.repositories;

import com.example.lab9.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {

}
