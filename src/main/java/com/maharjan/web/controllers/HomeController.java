package com.maharjan.web.controllers;

import com.maharjan.web.entities.Book;
import com.maharjan.web.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/")
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public String home() {
        return "Welcome to SpringBoot CRUD Kubernetes Project!";
    }

    @GetMapping("/book")
    public List<Book> getAllHotels() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{bookId}")
    public Book getHotel(@PathVariable String bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @PostMapping(path = "/book")
    public Book createBook(@RequestBody Book book){
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        return bookRepository.save(book);
    }
}
