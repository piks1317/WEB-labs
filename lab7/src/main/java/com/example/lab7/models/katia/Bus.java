package com.example.lab7.models.katia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;

    @Column(name = "car_number")
    private String carNumber;

    private Integer driver_id;

    public Bus(String brand, String carNumber, Integer driver_id) {
        this.brand = brand;
        this.carNumber = carNumber;
        this.driver_id = driver_id;
    }
}
