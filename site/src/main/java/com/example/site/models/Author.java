package com.example.site.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String surname;
    private String firstname;

    @Column(name = "birth_date")
    private String dateBirth;
    private String biography;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "writingabook", joinColumns = @JoinColumn(name = "author_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;


    public Author(String surname, String firstname, String dateBirth, String biography) {
        this.surname = surname;
        this.firstname = firstname;
        this.dateBirth = dateBirth;
        this.biography = biography;
        books = new HashSet<>();
    }

    public void addBook(Book book){
        book.getAuthors().add(this);
        books.add(book);
    }

    public void removeBook(Book book){
        book.getAuthors().remove(this);
        books.remove(book);
    }
}
