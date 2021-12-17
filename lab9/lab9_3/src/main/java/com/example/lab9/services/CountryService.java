package com.example.lab9.services;

import com.example.lab9.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public List<String> search(String str){
        List<String> result = new ArrayList<>();

        countryRepo.findAll().stream()
                .filter(country -> country.getName().toLowerCase().contains(str.toLowerCase()))
                .forEach(country -> result.add(country.getName()));

        return result;
    }
}
