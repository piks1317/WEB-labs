package com.example.lab7.controllers;

import com.example.lab7.models.julia.Medecine;
import com.example.lab7.models.julia.Pharmacy;
import com.example.lab7.models.julia.Producer;
import com.example.lab7.repositories.RepoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/julia")
public class JuliaController {

    private final RepoFactory repoFactory;

    public JuliaController(RepoFactory repoFactory) {
        this.repoFactory = repoFactory;
    }

    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("producers", repoFactory.getProducerRepository().findAll());
        model.addAttribute("pharmacies", repoFactory.getPharmacyRepository().findAll());
        model.addAttribute("medecines", repoFactory.getMedecineRepository().findAll());

        return "/julia/index";
    }

    @PostMapping("/newProducer")
    public String newProducer(@RequestParam("name") String name,
                              @RequestParam("address") String address,
                              @RequestParam("phone") String phone){
        repoFactory.getProducerRepository().save(new Producer(name, address, phone));

        return "redirect:index";
    }

    @PostMapping("/newPharmacy")
    public String newPharmacy(@RequestParam("name") String name,
                              @RequestParam("address") String address){
        repoFactory.getPharmacyRepository().save(new Pharmacy(name, address));

        return "redirect:index";
    }

    @PostMapping("/new")
    public String newMedecine(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("producer") Integer producer,
                              @RequestParam("pharmacy") Integer pharmacy){
        repoFactory.getMedecineRepository().save(new Medecine(pharmacy, producer, name, description));

        return "redirect:index";
    }

    @GetMapping("/{id}")
    public String showInfo(@PathVariable("id") int id, Model model){
        Medecine medecine = repoFactory.getMedecineRepository().getById(id);
        model.addAttribute("pharmacy", repoFactory.getPharmacyRepository().getById(medecine.getPharmacy_id()));
        model.addAttribute("producer", repoFactory.getProducerRepository().getById(medecine.getProducer_id()));
        model.addAttribute("medecine", repoFactory.getMedecineRepository().getById(id));

        return "/julia/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        repoFactory.getMedecineRepository().deleteById(id);
        return "redirect:index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("srch") String srch, Model model){
        Medecine medecine = repoFactory.getMedecineRepository().findByName(srch);
        model.addAttribute("pharmacy", repoFactory.getPharmacyRepository().getById(medecine.getPharmacy_id()));
        model.addAttribute("producer", repoFactory.getProducerRepository().getById(medecine.getProducer_id()));
        model.addAttribute("medecine", medecine);

        return "/julia/show";
    }
}
