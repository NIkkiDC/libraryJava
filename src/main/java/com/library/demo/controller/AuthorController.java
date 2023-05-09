package com.library.demo.controller;

import com.library.demo.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api") // http://localhost:9099/api
public class AuthorController {

    @GetMapping(path="/hello-world/")
    public String helloWorld() {
        return "Hello World!";
    }
// create(post) // update(put) // delete

    @GetMapping(path = "/books/")
    public List<Book> getBooks() {return books.getBooks();}


}

