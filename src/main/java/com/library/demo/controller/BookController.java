package com.library.demo.controller;
import com.library.demo.model.Book;
import com.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

}