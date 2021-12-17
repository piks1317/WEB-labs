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
@Table(name = "publishinghouses")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contact;
    private String site;

    @OneToMany(mappedBy = "publishingHouse")
    private Set<Book> books = new HashSet<>();

    public PublishingHouse(String name, String contact, String site) {
        this.name = name;
        this.contact = contact;
        this.site = site;
    }

    public void addBook(Book book){
        books.add(book);
        book.setPublishingHouse(this);
    }
     public void removeBook(Book book){
        books.remove(book);
        book.setPublishingHouse(null);
     }
}
