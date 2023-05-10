package com.library.demo.controller;

import com.library.demo.exception.InformationExistException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api") // http://localhost:9099/api
public class AuthorController {

    private AuthorRepo authorRepo;


    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }


    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping(path = "/author/")
    public Author createAuthor(@RequestBody Author authorObject){
        Author author = authorRepo.findByName(authorObject.getName());
        if (author != null){
            throw new InformationExistException("Author with this name exist already");
        } else {
            return authorRepo.save(authorObject);
        }
    }
    @GetMapping(path = "/author/{authorId}/") // author ONLY
    public Optional<Author> getAuthor(@PathVariable Long authorId){
        return authorRepo.findById(authorId);
    }
}
