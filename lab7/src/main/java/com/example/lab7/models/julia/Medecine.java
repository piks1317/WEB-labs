package com.example.lab7.models.julia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "medecines")
@Getter
@Setter
@NoArgsConstructor
public class Medecine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer pharmacy_id;
    private Integer producer_id;
    private String name;
    @Column(name = "discription")
    private String description;

    public Medecine(Integer pharmacy_id, Integer producer_id, String name, String description) {
        this.pharmacy_id = pharmacy_id;
        this.producer_id = producer_id;
        this.name = name;
        this.description = description;
    }
}
