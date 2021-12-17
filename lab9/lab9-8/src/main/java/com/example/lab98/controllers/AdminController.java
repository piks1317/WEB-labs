package com.example.lab98.controllers;

import com.example.lab98.models.User;
import com.example.lab98.repositories.UserRepo;
import com.example.lab98.security.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepo userRepo;
    private final RegistrationService registrationService;

    public AdminController(UserRepo userRepo, RegistrationService registrationService) {
        this.userRepo = userRepo;
        this.registrationService = registrationService;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "index";
    }

    @RequestMapping("/delete")
    public @ResponseBody void deleteUser(@RequestParam("id") Integer id){
        userRepo.delete(userRepo.getById(id));
    }

    @RequestMapping("/add")
    public @ResponseBody String addUser(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("role") String role){
        User user = new User(username, password, role);
        registrationService.register(user);
        return role;
    }

    @RequestMapping("/change")
    public @ResponseBody String changeGroup(@RequestParam("role") String role,
                                          @RequestParam("id") Integer id){
        User user = userRepo.getById(id);
        user.setRole(role);
        userRepo.save(user);
        return role;
    }
}
