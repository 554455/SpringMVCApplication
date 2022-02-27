package com.umaraliev.springmvcapplication.controllers;

import com.umaraliev.springmvcapplication.model.Book;
import com.umaraliev.springmvcapplication.srvice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@ComponentScan("com.umaraliev.springmvcapplication")
@EnableWebMvc
public class HomeController {


    private final BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String getAll(Model model) {
        List<Book> getAll = bookService.getAll();
        model.addAttribute("books", getAll);
        return "home";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    @PostMapping("book-create")
    public String createBook(Book book) {
        bookService.save(book);
        return "redirect:/home";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("book-update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/home";
    }

    @GetMapping("book-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        bookService.delete(id);
        return "redirect:/home";
    }
}
