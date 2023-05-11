package com.library.demo.controller;

import com.library.demo.exception.InformationExistException;
import com.library.demo.exception.InformationNotFoundException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import com.library.demo.service.AuthorService;
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

    @Autowired
    private AuthorService authorService;


    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return authorService.helloWorld();
    }

    /**
     * This method is used to create a new Author object inside the database additionally it is
     * ensuring that there are no duplicates based on the authors name. It will throw an exception
     * if the author with the same name already exists.
     *
     * @param authorObject
     * @return
     */

    @PostMapping(path = "/author/")
    public Author createAuthor(@RequestBody Author authorObject) {
        return authorService.createAuthor(authorObject);
    }

    /**
     * This method is used to retrieve a single Author object from a database using the ID.
     *
     * @param authorId
     * @return
     */

    @GetMapping(path = "/author/{authorId}/")
    public Optional<Author> getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    /**
     * This method is used to obtain ALL Author objects from a database and return it as a list
     *
     * @return
     */

    @GetMapping(path = "/author/") // author ONLY
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    /**
     * This method is used to update the existing Author object in the database with new data, and
     * cease the creation of a duplicate Author object with the same name
     *
     * @param authorId
     * @param authorObject
     * @return
     */

    @PutMapping(path = "/author/{authorId}/")
    public Author updateAuthor(@PathVariable Long authorId, @RequestBody Author authorObject) {
        return authorService.updateAuthor(authorId, authorObject);
    }

    /**
     * This method is used to delete an existing Author object from the database
     * and handle the instance where the object does not exist in the database
     *
     * @param authorId
     */

    @DeleteMapping(path = "author/{authorId}/")
    public void deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }
}
