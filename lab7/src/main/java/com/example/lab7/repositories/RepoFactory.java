package com.example.lab7.repositories;

import com.example.lab7.repositories.julia.MedecineRepository;
import com.example.lab7.repositories.julia.PharmacyRepository;
import com.example.lab7.repositories.julia.ProducerRepository;
import com.example.lab7.repositories.katia.BusRepository;
import com.example.lab7.repositories.katia.DriverRepository;
import com.example.lab7.repositories.katia.RoutRepository;
import com.example.lab7.repositories.katia.SheduleRepository;
import com.example.lab7.repositories.vova.EquipmentRepository;
import com.example.lab7.repositories.vova.KindRepository;
import com.example.lab7.repositories.vova.TypeRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Component
public class RepoFactory {

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private KindRepository kindRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RoutRepository routRepository;
    @Autowired
    private SheduleRepository sheduleRepository;
    @Autowired
    private MedecineRepository medecineRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private ProducerRepository producerRepository;

}
