package com.example.lab9.services;

import com.example.lab9.models.Person;
import com.example.lab9.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    private PersonRepo personRepo;

    public String findByEmail(String email){
        if (email == "")
            return "Email should not be empty";
        Person person = personRepo.findPersonByEmail(email);
        return (person == null) ? "Unique"  : "Duplicate";
    }

    public String validateAge(Integer age){
        if (age > 100 || age <= 0)
            return "Age must be garter than 0 and lower than 100";
        return "Success";
    }

    public String isValidPassword(String password) {

        if (password.length() > 15 || password.length() < 8) {
            return "Password must be less than 20 and more than 8 characters in length.";
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars )) {
            return "Password must have atleast one uppercase character";
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars )) {
           return "Password must have atleast one lowercase character";
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers )) {
            return "Password must have atleast one number";
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars )) {
            return "Password must have atleast one special character among @#$%";
        }
        return "Password Success";
    }

    public void savePerson(Person person){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepo.save(person);
    }
}
