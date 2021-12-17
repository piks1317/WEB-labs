package com.example.site.repositories;

import com.example.site.models.Author;
import com.example.site.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    List<Book> findAllByName(String name);
    List<Book> findAllByGenre_Id(Integer genre);
    List<Book> findAllByNameAndGenre_Id(String name, Integer genreId);
    List<Book> findAllByAuthorsContains(Author author);
    List<Book> findAllByNameAndAuthorsContains(String name, Author author);
    List<Book> findAllByNameAndGenre_IdAndAuthorsContains(String name, Integer genreId, Author author);
}
