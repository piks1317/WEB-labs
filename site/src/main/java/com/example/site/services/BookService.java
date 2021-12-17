package com.example.site.services;

import com.example.site.models.Author;
import com.example.site.models.Book;
import com.example.site.models.PublishingHouse;
import com.example.site.repositories.AuthorRepository;
import com.example.site.repositories.BookRepository;
import com.example.site.repositories.RepoFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final RepoFactory repoFactory;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, RepoFactory repoFactory) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.repoFactory = repoFactory;
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Author updateAuthor(Author updatedAuthor){
        Author author = repoFactory.getAuthorRepository().getById(updatedAuthor.getId());

        author.setFirstname(updatedAuthor.getFirstname());
        author.setSurname(updatedAuthor.getSurname());
        author.setDateBirth(updatedAuthor.getDateBirth());
        author.setBiography(updatedAuthor.getBiography());

        return repoFactory.getAuthorRepository().save(author);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAuthor(Author author){
        author.getBooks().forEach(i->i.removeAuthor(author));
        repoFactory.getAuthorRepository().delete(author);
    }



    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBook(Book book){
        book.getAuthors().forEach(i-> i.removeBook(book));
        bookRepository.delete(book);
    }


    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book updateBook(Book updatedBook){
        Book book = bookRepository.getById(updatedBook.getId());

        book.setName(updatedBook.getName());
        book.setGenre(updatedBook.getGenre());
        book.setPublicationYear(updatedBook.getPublicationYear());
        book.setDescription(updatedBook.getDescription());
        book.setPublishingHouse(updatedBook.getPublishingHouse());
        book.setLink(updatedBook.getLink());
        book.setAuthors(updatedBook.getAuthors());
        updatedBook.getPublishingHouse().addBook(book);

        return bookRepository.save(book);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PublishingHouse updatePubHouse(PublishingHouse pubhouse){
        PublishingHouse publishingHouse = repoFactory.getPublishingHouseRepository().getById(pubhouse.getId());

        publishingHouse.setName(pubhouse.getName());
        publishingHouse.setContact(pubhouse.getContact());
        publishingHouse.setSite(pubhouse.getSite());

        return repoFactory.getPublishingHouseRepository().save(publishingHouse);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePubHouse(PublishingHouse publishingHouse){
        publishingHouse.getBooks().forEach(i->i.setPublishingHouse(null));
        repoFactory.getPublishingHouseRepository().delete(publishingHouse);
    }


    public List<Book> search(String name, Integer genre, String author){

        if(name != "" && genre == null && author == "")
            return repoFactory.getBookRepository().findAllByName(name);
        if (name == "" && genre != null && author == "")
            return repoFactory.getBookRepository().findAllByGenre_Id(genre);
        if (name == "" && genre == null && author != "")
            return repoFactory.getBookRepository().findAllByAuthorsContains(repoFactory.getAuthorRepository().findBySurname(author));
        if (name != "" && genre != null && author == "")
            return repoFactory.getBookRepository().findAllByNameAndGenre_Id(name, genre);
        if (name != "" && author != "" && genre == null)
            return repoFactory.getBookRepository().findAllByNameAndAuthorsContains(name,
                    repoFactory.getAuthorRepository().findBySurname(author));
        if (genre != null && author != "" && name == "")
            return repoFactory.getBookRepository().findAllByNameAndGenre_Id(name, genre);

        return repoFactory.getBookRepository().findAllByNameAndGenre_IdAndAuthorsContains(name, genre,
                repoFactory.getAuthorRepository().findBySurname(author));
    }


    public List<String> searchNames(String str){
        List<String> result = new ArrayList<>();

        bookRepository.findAll().stream()
                .filter(book -> book.getName().toLowerCase().contains(str.toLowerCase()))
                .forEach(book -> result.add(book.getName()));

        return result;
    }

    public List<String> searchAuthors(String str){
        List<String> result = new ArrayList<>();

        authorRepository.findAll().stream()
                .filter(author -> author.getSurname().toLowerCase().contains(str.toLowerCase()))
                .forEach(author -> result.add(author.getSurname()));
        return result;
    }
}
