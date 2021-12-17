package com.example.lab7.controllers;

import com.example.lab7.models.vova.Equipment;
import com.example.lab7.models.vova.Kind;
import com.example.lab7.models.vova.Type;
import com.example.lab7.repositories.RepoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vova")
public class VovaContoller {

    private final RepoFactory repoFactory;


    public VovaContoller(RepoFactory repoFactory) {
        this.repoFactory = repoFactory;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("kinds", repoFactory.getKindRepository().findAll());
        model.addAttribute("types", repoFactory.getTypeRepository().findAll());
        model.addAttribute("equipments", repoFactory.getEquipmentRepository().findAll());

        return "vova/index";
    }

    @PostMapping("/newKind")
    public String newKind(@RequestParam("kind") String kind){
        repoFactory.getKindRepository().save(new Kind(kind));
        return "redirect:index";
    }

    @PostMapping("/newType")
    public String newType(@RequestParam("type") String type){
        repoFactory.getTypeRepository().save(new Type(type));
        return "redirect:index";
    }

    @PostMapping("/new")
    public String newEquipment(@RequestParam("name") String name,
                               @RequestParam("kind") Integer kind, @RequestParam("type") Integer type){

        Equipment equipment;
        if(kind == null || type == null)
            equipment = new Equipment(name);
        else
            equipment = new Equipment(name, repoFactory.getKindRepository().getById(kind), repoFactory.getTypeRepository().getById(type));
        repoFactory.getEquipmentRepository().save(equipment);
        return "redirect:index";
    }

    @GetMapping("/{id}")
    public String showInfo(@PathVariable("id") int id, Model model){
        Equipment equipment = repoFactory.getEquipmentRepository().getById(id);
        model.addAttribute("equipment", equipment);
        model.addAttribute("kind", equipment.getKind());
        model.addAttribute("type", equipment.getType());

        return "/vova/show";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        repoFactory.getEquipmentRepository().deleteById(id);
        return "redirect:index";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam("srch") String srch, Model model){
//        Equipment equipment = repoFactory.getEquipmentRepository().findByName(srch);
//        model.addAttribute("equipment", equipment);
//        model.addAttribute("kind", repoFactory.getKindRepository().getById(equipment.getKind_id()));
//        model.addAttribute("type", repoFactory.getTypeRepository().getById(equipment.getType_id()));
//        return "/vova/show";
//    }
}
