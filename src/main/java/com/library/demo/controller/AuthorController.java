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

    @PostMapping(path = "/author/")
    public Author createAuthor(@RequestBody Author authorObject) {
        Author author = authorRepo.findByName(authorObject.getName());
        if (author != null) {
            throw new InformationExistException("Author with this name exist already");
        } else {
            return authorRepo.save(authorObject);
        }
    }

    @GetMapping(path = "/author/{authorId}/")
    public Optional<Author> getAuthor(@PathVariable Long authorId) {
        return authorRepo.findById(authorId);
    }


    @GetMapping(path = "/author/") // author ONLY
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }


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
}

//        @DeleteMapping(path = "author/{authorId}/")
//    public Optional<Author> deleteAuthor(@PathVariable(value = "authorId") Long authorId){
//        return deleteAuthor(authorId);
//    }
//}
