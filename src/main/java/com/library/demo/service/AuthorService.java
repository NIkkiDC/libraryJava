package com.library.demo.service;

import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }
    public Optional<Author> getAuthorById(Long id){
        return authorRepo.findById(id);
    }
    public Author createAuthor(Author author){
        return authorRepo.save(author);
    }



}
