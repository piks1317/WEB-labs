package com.example.lab7.models.katia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
public class Rout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    public Rout(String name) {
        this.name = name;
    }


}
