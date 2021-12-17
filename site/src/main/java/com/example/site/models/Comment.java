package com.example.site.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "discription")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime date;

    public Comment(String description, User user, Book book) {
        this.description = description;
        this.user = user;
        this.book = book;
        date = LocalDateTime.now();
    }

    public Comment(String description) {
        this.description = description;
    }

}
