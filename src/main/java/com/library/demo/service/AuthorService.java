package com.library.demo.service;

import com.library.demo.exception.InformationExistException;
import com.library.demo.exception.InformationNotFoundException;
import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }

    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * If an Author with the same name does not exit it saves the author object to the
     * database utilizing  the save() method os the authorRepo then will return the saved
     * Author object
     * @param authorObject
     * @return
     */

    public Author createAuthor(Author authorObject) {
        Author author = authorRepo.findByName(authorObject.getName());
        if (author != null) {
            throw new InformationExistException("Author with this name exist already");
        } else {
            return authorRepo.save(authorObject);
        }
    }

    /**
     * This method is created to return the Optional object. Which will then allow the
     * caller to handle the case where the author may or may not exist in the database
     * @param authorId
     * @return
     */

    public Optional<Author> getAuthor(Long authorId) {
        return authorRepo.findById(authorId);
    }

    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    public Author updateAuthor(Long authorId, Author authorObject) {
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
    public void deleteAuthor(Long authorId){
        Optional<Author> author = authorRepo.findById(authorId);
        if (author.isPresent()){
            Author author_to_delete = author.get();
            authorRepo.delete(author_to_delete);
        } else {
            throw new InformationExistException("Author with id "+ authorId +" not found");
        }
    }

}
