package com.library.demo.controller;

import com.library.demo.exception.InformationExistException;
import com.library.demo.exception.InformationNotFoundException;
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

    /**\
     * This method is used to create a new Author object inside the database additionally it is
     * ensuring that there are no duplicates based on the authors name. It will throw an exception
     * if the author with the same name already exists.
     * @param authorObject
     * @return
     */

    @PostMapping(path = "/author/")
    public Author createAuthor(@RequestBody Author authorObject) {
        Author author = authorRepo.findByName(authorObject.getName());
        if (author != null) {
            throw new InformationExistException("Author with this name exist already");
        } else {
            return authorRepo.save(authorObject);
        }
    }

    /**
     * This method is used to retrieve a single Author object from a database using the ID.
     * @param authorId
     * @return
     */

    @GetMapping(path = "/author/{authorId}/")
    public Optional<Author> getAuthor(@PathVariable Long authorId) {
        return authorRepo.findById(authorId);
    }

    /**
     * This method is used to obtain ALL Author objects from a database and return it as a list
     * @return
     */

    @GetMapping(path = "/author/") // author ONLY
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    /**
     * This method is used to update the existing Author object in the database with new data, and
     * cease the creation of a duplicate Author object with the same name
     * @param authorId
     * @param authorObject
     * @return
     */

    @PutMapping(path = "/author/{authorId}/")
    public Author updateAuthor(@PathVariable Long authorId, @RequestBody Author authorObject) {
        Optional<Author> author = authorRepo.findById(authorId);
        if (author.isPresent()) {
            if (authorObject.getName().equals(author.get().getName())) {
                throw new InformationExistException("Author " + author.get().getName() + " already exists.");
            } else {
                Author updateAuthor = authorRepo.findById(authorId).get();
                updateAuthor.setName(authorObject.getName());
                updateAuthor.setDescription(authorObject.getDescription());
                return authorRepo.save(updateAuthor);
            }
        } else {
            throw new InformationNotFoundException("Author with id " + authorId + " not found");
        }
    }

    /**
     * This method is used to delete an existing Author object from the database
     * and handle the instance where the object does not exist in the database
     * @param authorId
     */

    @DeleteMapping(path = "author/{authorId}/")
    public void deleteAuthor(@PathVariable(value = "authorId") Long authorId){
        Optional<Author> author = authorRepo.findById(authorId);
        if (author.isPresent()){
            Author author_to_delete = author.get();
            authorRepo.delete(author_to_delete);
        } else {
            throw new InformationExistException("Author with id "+ authorId +" not found");
        }
    }
}
