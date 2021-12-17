package com.example.lab7.models.vova;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipmentkind")
@Getter
@Setter
@NoArgsConstructor
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kind")
    private String kind;

    @OneToMany
    private List<Equipment> equipments;

    public Kind(String kind){
        this.kind = kind;
        equipments = new ArrayList<>();
    }


}
