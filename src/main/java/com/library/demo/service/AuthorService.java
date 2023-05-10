package com.library.demo.service;

import com.library.demo.exception.InformationNotFoundException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class AuthorService {

    private AuthorRepo authorRepo;

    /**
     *
     * @param authorRepo
     */


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

    public Optional<Author> updateAuthor(Long authorId, Author authorObject) throws InformationNotFoundException {
        Optional<Author> author = authorRepo.findById(authorId);
        if (author.isPresent()){
            author.get().setName(authorObject.getName());
            author.get().setDescription(authorObject.getDescription());
            authorRepo.save(author.get());
            return author;
        } else {
            throw new InformationNotFoundException("Author with id " +authorId + " was not found");
        }
    }



}
