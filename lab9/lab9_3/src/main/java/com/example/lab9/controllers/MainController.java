package com.example.lab9.controllers;

import com.example.lab9.models.Person;
import com.example.lab9.services.CityService;
import com.example.lab9.services.CountryService;
import com.example.lab9.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class MainController {


   private final PersonService personService;
   private final CountryService countryService;
   private final CityService cityService;

    public MainController(PersonService personService, CountryService countryService, CityService cityService) {
        this.personService = personService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping("")
    public String index(@ModelAttribute("person")Person person){
        return "index";
    }

    @RequestMapping("/validateEmail")
    public @ResponseBody String checkEmail(@RequestParam(value = "email") String email){
        return personService.findByEmail(email);
    }

    @RequestMapping("/validateAge")
    public @ResponseBody String checkAge(@RequestParam(value = "age") Integer age){
        return personService.validateAge(age);
    }

    @RequestMapping("/validatePassword")
    public @ResponseBody String chackPassword(@RequestParam(value = "password") String password){
        return personService.isValidPassword(password);
    }

    @RequestMapping("/searchCity")
    public @ResponseBody List<String> searchCity(@RequestParam("string") String string){
        return cityService.search(string);
    }

    @RequestMapping("/searchCountry")
    public @ResponseBody List<String> searchCountry(@RequestParam("string") String string){
        return countryService.search(string);
    }

    @PostMapping("/registrate")
    public String registrate(@ModelAttribute("person")Person person){
        personService.savePerson(person);
        return "redirect:/api";
    }
}
