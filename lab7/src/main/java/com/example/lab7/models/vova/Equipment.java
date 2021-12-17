package com.example.lab7.models.vova;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "computerequipment")
@Getter
@Setter
public class Equipment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kind kind;


    public Equipment(){}

    public Equipment(String name) {
        this.name = name;
    }

    public Equipment(String name, Kind kind, Type type) {
        this.name = name;
        this.kind = kind;
        this.type = type;
    }
}
