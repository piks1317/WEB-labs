package com.example.site.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
