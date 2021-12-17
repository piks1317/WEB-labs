package com.example.lab9_2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "latters")
@Getter
@Setter
@NoArgsConstructor
public class Latter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idsender")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "idrecipient")
    private User recipient;
    private String text;
    private LocalDateTime date;

    public Latter(User sender, User recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        date = LocalDateTime.now();
    }
}
