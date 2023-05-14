package com.library.demo.service;

import com.library.demo.model.Book;
import com.library.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }
}

