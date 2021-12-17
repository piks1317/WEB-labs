package com.example.site.controllers;

import com.example.site.models.Book;
import com.example.site.models.Comment;
import com.example.site.models.User;
import com.example.site.repositories.RepoFactory;
import com.example.site.security.UserDetailsImpl;
import com.example.site.services.BookService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class FrontController {

    private final RepoFactory repoFactory;
    private final BookService bookService;

    public FrontController(RepoFactory repoFactory, BookService bookService) {
        this.repoFactory = repoFactory;
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String index(@ModelAttribute("user") User user, Model model){

        model.addAttribute("authors", repoFactory.getAuthorRepository().findAll());
        model.addAttribute("genres", repoFactory.getGenreRepository().findAll());
        model.addAttribute("books", repoFactory.getBookRepository().findAll());
        return "index";
    }

    @GetMapping("/showBook/{id}")
    public String showBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", repoFactory.getBookRepository().getById(id));

        return "show";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetails.getUser());

        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name") String name,
                         @RequestParam(value = "genre", required = false) Integer genre,
                         @RequestParam("author") String author, Model model) {

        model.addAttribute("authors", repoFactory.getAuthorRepository().findAll());
        model.addAttribute("genres", repoFactory.getGenreRepository().findAll());
        model.addAttribute("books", repoFactory.getBookRepository().findAll());

        model.addAttribute("search", bookService.search(name, genre, author));

        model.addAttribute("name", name);
        if (genre != null)
            model.addAttribute("genre", repoFactory.getGenreRepository().getById(genre).getName());
        model.addAttribute("author", author);

        return "search";
    }

    @PostMapping("/comment/{id}")
    public String addComment(@RequestParam("comment") String comment,
                             @RequestParam("user") String name,
                             @PathVariable("id") Integer bookId,
                             Model model){
        User user = repoFactory.getUserRepository().getUserByUsername(name);
        Book book = repoFactory.getBookRepository().getById(bookId);
        repoFactory.getCommentRepository().save(new Comment(comment, user, book));
        model.addAttribute("book", book);

        return "show";
    }


}
