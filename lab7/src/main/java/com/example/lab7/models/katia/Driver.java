package com.example.lab7.models.katia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String surname;

    @Column(name = "drivers_license")
    private String driversLicense;

    public Driver(String firstname, String surname, String driversLicense) {
        this.firstname = firstname;
        this.surname = surname;
        this.driversLicense = driversLicense;
    }
}
