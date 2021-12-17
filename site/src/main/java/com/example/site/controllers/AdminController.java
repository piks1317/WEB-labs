package com.example.site.controllers;

import com.example.site.models.Author;
import com.example.site.models.Book;
import com.example.site.models.Genre;
import com.example.site.models.PublishingHouse;
import com.example.site.repositories.RepoFactory;
import com.example.site.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RepoFactory repoFactory;
    private final BookService bookService;

    public AdminController(RepoFactory repoFactory, BookService bookService) {
        this.repoFactory = repoFactory;
        this.bookService = bookService;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("books", repoFactory.getBookRepository().findAll());
        model.addAttribute("authors", repoFactory.getAuthorRepository().findAll());
        model.addAttribute("pubhouses", repoFactory.getPublishingHouseRepository().findAll());

        return "admin/index";
    }

    @GetMapping("/newbook")
    public String newBookPage(@ModelAttribute("book")Book book, Model model){
        model.addAttribute("pubhouses", repoFactory.getPublishingHouseRepository().findAll());
        model.addAttribute("genres", repoFactory.getGenreRepository().findAll());
        model.addAttribute("selectedauthors", repoFactory.getAuthorRepository().findAll());

        return "admin/newBook";
    }

    @GetMapping("/new")
    public String newAuthorPage(@ModelAttribute("author")Author author,
                                @ModelAttribute("pubhouse")PublishingHouse publishingHouse) {
        return "admin/new";
    }

    @PostMapping("/newAuthor")
    public String newAuthor(@ModelAttribute("author")Author author){
        repoFactory.getAuthorRepository().save(author);
        return "redirect:/admin";
    }

    @PostMapping("/newPubHouse")
    public String newPublishingHouse(@ModelAttribute("pubhouse") PublishingHouse publishingHouse){
        repoFactory.getPublishingHouseRepository().save(publishingHouse);
        return "redirect:/admin";
    }

    @PostMapping("/newGenre")
    public String newGenre(@RequestParam("name") String name){
        repoFactory.getGenreRepository().save(new Genre(name));

        return "redirect:newbook";
    }

    @RequestMapping("/genre")
    public @ResponseBody String addGenre(@RequestParam("name") String name){
        repoFactory.getGenreRepository().save(new Genre(name));
        return name;
    }

    @RequestMapping("/add")
    public @ResponseBody String addpubhouse(@RequestParam("name") String name,
                                            @RequestParam("contact") String contact,
                                            @RequestParam("site") String site){
        PublishingHouse publishingHouse = new PublishingHouse(name, contact, site);
        repoFactory.getPublishingHouseRepository().save(publishingHouse);

        return name;
    }


    @PostMapping("/newBook")
    public String newBook(@ModelAttribute("book")Book book,
                          @RequestParam("genre") Integer genre,
                          @RequestParam("pubhouse") Integer pubhouse,
                          @RequestParam("authors")Set<Author> authors){
        book.setGenre(repoFactory.getGenreRepository().getById(genre));
        repoFactory.getPublishingHouseRepository().getById(pubhouse).addBook(book);
        book.setPublishingHouse(repoFactory.getPublishingHouseRepository().getById(pubhouse));
        authors.forEach(book::addAuthor);

        repoFactory.getBookRepository().save(book);

        return "redirect:/admin";
    }

    @GetMapping("/updateBook/{id}")
    public String updateBookPage(Model model, @PathVariable("id") Integer id){
        model.addAttribute("book", repoFactory.getBookRepository().getById(id));
        model.addAttribute("genres", repoFactory.getGenreRepository().findAll());
        model.addAttribute("pubhouses", repoFactory.getPublishingHouseRepository().findAll());
        model.addAttribute("authors", repoFactory.getAuthorRepository().findAll());

        return "admin/updateBook";
    }

    @PatchMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book,
                             @RequestParam("id") int id,
                             @RequestParam("genre") Integer genre,
                             @RequestParam("pubhouse") Integer pubhouse,
                             @RequestParam(value = "authors", required = false) Set<Author> authors,
                             @RequestParam(value = "delauthor", required = false) Integer author){
        book.setId(id);
        book.setGenre(repoFactory.getGenreRepository().getById(genre));
        book.setPublishingHouse(repoFactory.getPublishingHouseRepository().getById(pubhouse));
        if (author != null){
            book.removeAuthor(repoFactory.getAuthorRepository().getById(author));
        }


        if (!authors.isEmpty())
            authors.forEach(book::addAuthor);

        bookService.updateBook(book);

        return "redirect:/admin";
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(repoFactory.getBookRepository().getById(id));

        return "redirect:/admin";
    }

    @GetMapping("/updateAuthor/{id}")
    public String updateAuthorPage(Model model, @PathVariable("id") int id){
        model.addAttribute("author", repoFactory.getAuthorRepository().getById(id));

        return "admin/updateAuthor";
    }

    @PatchMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("author") Author author,
                               @RequestParam("id") int id){
        author.setId(id);
        bookService.updateAuthor(author);

        return "redirect:/admin";
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable("id") int id){
        bookService.deleteAuthor(repoFactory.getAuthorRepository().getById(id));

        return "redirect:/admin";
    }

    @GetMapping("/updatePubhouse/{id}")
    public String updatePubhousePage(Model model, @PathVariable("id") int id){
        model.addAttribute("pubhouse", repoFactory.getPublishingHouseRepository().getById(id));

        return "admin/updatePubhouse";
    }

    @PatchMapping("/updatePubHouse")
    public String updatePubHouse(@ModelAttribute("pubhouse") PublishingHouse pubhouse,
                                 @RequestParam("id") int id){
        pubhouse.setId(id);
        bookService.updatePubHouse(pubhouse);
        return "redirect:/admin";
    }

    @DeleteMapping("/deletePubhouse/{id}")
    public String deletePubHouse(@PathVariable("id") int id){
        bookService.deletePubHouse(repoFactory.getPublishingHouseRepository().getById(id));

        return "redirect:/admin";
    }

    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") Integer commentId,
                                @RequestParam("bookId") Integer bookId,
                                Model model){

        repoFactory.getCommentRepository().delete(repoFactory.getCommentRepository().getById(commentId));
        model.addAttribute("book", repoFactory.getBookRepository().getById(bookId));

        return "show";
    }

}
