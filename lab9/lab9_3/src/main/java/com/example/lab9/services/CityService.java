package com.example.lab9.services;

import com.example.lab9.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepo cityRepo;

    public List<String> search(String str){
        List<String> result = new ArrayList<>();

        cityRepo.findAll().stream()
            .filter(city -> city.getName().toLowerCase().contains(str.toLowerCase()))
            .forEach(city -> result.add(city.getName()));

        return result;
    }
}
