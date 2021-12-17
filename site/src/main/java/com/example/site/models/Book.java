package com.example.site.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @Column(name = "publication_year")
    private int publicationYear;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    private String link;

    @ManyToMany(mappedBy = "books", fetch=FetchType.EAGER)
    private Set<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

    public Book(String name, Genre genre, int publicationYear, String description, PublishingHouse publishingHouse, String link) {
        this.name = name;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.description = description;
        this.publishingHouse = publishingHouse;
        this.link = link;
        authors = new HashSet<>();
    }

    public void addAuthor(Author author){
        author.getBooks().add(this);
        authors.add(author);
    }

    public void removeAuthor(Author author){
        authors.remove(author);
        author.getBooks().remove(this);
    }
}
