package com.example.lab9_2.controllers;

import com.example.lab9_2.models.Latter;
import com.example.lab9_2.models.User;
import com.example.lab9_2.repositories.LatterRepo;
import com.example.lab9_2.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MainController {

    private final UserRepo userRepo;
    private final LatterRepo latterRepo;

    public MainController(UserRepo userRepo, LatterRepo latterRepo) {
        this.userRepo = userRepo;
        this.latterRepo = latterRepo;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String sayHello() {
        return "index";
    }

    @RequestMapping("/sendLatter")
    public @ResponseBody void sendLatter(@RequestParam("recipient") String recipientName,
                             @RequestParam("text") String text,
                             @RequestParam("sender") String senderName){

        User recipient = userRepo.findUserByLogin(recipientName);
        User sender = userRepo.findUserByLogin(senderName);
        latterRepo.save(new Latter(sender, recipient, text));
    }

    @PostMapping("/showIncomming")
    public String showIncommings(@RequestParam("sender") String senderName,
                                 Model model){
        User user = userRepo.findUserByLogin(senderName);
        model.addAttribute("latters", latterRepo.findAllByRecipient(user));
        return "latterList";
    }

    @PostMapping("/showOutcomming")
    public String showOutcommings(@RequestParam("sender") String senderName,
                                 Model model){
        User user = userRepo.findUserByLogin(senderName);
        model.addAttribute("latters", latterRepo.findAllBySender(user));
        return "latterList";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLatter(@PathVariable("id") Integer id){
        latterRepo.delete(latterRepo.getById(id));
        return "redirect:/api/index";
    }
}
