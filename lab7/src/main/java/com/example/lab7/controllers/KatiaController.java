package com.example.lab7.controllers;

import com.example.lab7.models.katia.Bus;
import com.example.lab7.models.katia.Driver;
import com.example.lab7.models.katia.Rout;
import com.example.lab7.models.katia.Shedule;
import com.example.lab7.repositories.RepoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/katia")
public class KatiaController {

    private final RepoFactory repoFactory;

    public KatiaController(RepoFactory repoFactory) {
        this.repoFactory = repoFactory;
    }

    @GetMapping("/index")
    public String index(Model model){
        if(repoFactory.getDriverRepository().findAll()!=null)
            model.addAttribute("drivers", repoFactory.getDriverRepository().findAll());
        if(repoFactory.getRoutRepository().findAll()!=null)
            model.addAttribute("routes", repoFactory.getRoutRepository().findAll());
        if(repoFactory.getBusRepository().findAll()!=null)
            model.addAttribute("buses", repoFactory.getBusRepository().findAll());
        if(repoFactory.getSheduleRepository().findAll()!=null)
            model.addAttribute("schedules", repoFactory.getSheduleRepository().findAll());

        return "/katia/index";
    }

    @PostMapping("/newDriver")
    public String newDriver(@RequestParam("firstname") String firstname,
                            @RequestParam("surname") String surname,
                            @RequestParam("driversLicense") String driversLicense){
        repoFactory.getDriverRepository().save(new Driver(firstname, surname, driversLicense));

        return "redirect:index";
    }

    @PostMapping("/newRout")
    public String newRout(@RequestParam("name") String name){
        repoFactory.getRoutRepository().save(new Rout(name));

        return "redirect:index";
    }

    @PostMapping("/newBus")
    public String newBus(@RequestParam("brand") String brand,
                         @RequestParam("carnumber") String carNumber,
                         @RequestParam("driver") Integer driver_id){
        repoFactory.getBusRepository().save(new Bus(brand, carNumber, driver_id));

        return "redirect:index";
    }

    @PostMapping("/newShedule")
    public String newShedule(@RequestParam("date") String date,
                             @RequestParam("departureTime") String departureTime,
                             @RequestParam("arrivalTime") String arrivalTime,
                             @RequestParam("rout") Integer rout,
                             @RequestParam("bus") Integer bus){
        repoFactory.getSheduleRepository().save(new Shedule(rout, bus, date, departureTime, arrivalTime));

        return "redirect:index";
    }

    @GetMapping("/{id}")
    public String showInfo(@PathVariable("id") int id, Model model){
        Shedule shedule = repoFactory.getSheduleRepository().findByRouteId(id);
        Bus bus = repoFactory.getBusRepository().getById(shedule.getBus_id());
        model.addAttribute("shedule", shedule);
        model.addAttribute("rout", repoFactory.getRoutRepository().getById(id));
        model.addAttribute("bus", bus);
        model.addAttribute("driver", repoFactory.getDriverRepository().getById(bus.getDriver_id()));

        return "/katia/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        repoFactory.getSheduleRepository().deleteById(id);
        return "redirect:index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("srch") String srch, Model model){
        Rout rout = repoFactory.getRoutRepository().findByName(srch);
        Shedule shedule = repoFactory.getSheduleRepository().findByRouteId(rout.getId());
        Bus bus = repoFactory.getBusRepository().getById(shedule.getBus_id());
        model.addAttribute("shedule", shedule);
        model.addAttribute("rout", rout);
        model.addAttribute("bus", bus);
        model.addAttribute("driver", repoFactory.getDriverRepository().getById(bus.getDriver_id()));

        return "/katia/show";
    }
}
