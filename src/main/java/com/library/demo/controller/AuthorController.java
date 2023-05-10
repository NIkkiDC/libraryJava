package com.library.demo.controller;

import com.library.demo.model.Author;
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
}
