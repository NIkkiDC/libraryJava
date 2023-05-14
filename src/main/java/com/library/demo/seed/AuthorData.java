package com.library.demo.seed;

import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorData implements CommandLineRunner {

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public void run(String... args) throws Exception {
        dataForAuthor();
    }

    private void dataForAuthor () {
        if (authorRepo.count() == 0) {
            Author author1 = new Author("Toni Morrison", "An American novelist.");
            Author author2 = new Author("Alice Walker", "An American novelist.");
            Author author3 = new Author("Octavia E. Butler", "An American novelist.");
            Author author4 = new Author("Maya Angelou", "An American novelist.");
            Author author5 = new Author("Eric Thomas", "An American novelist.");
            authorRepo.save(author1);
            authorRepo.save(author2);
            authorRepo.save(author3);
            authorRepo.save(author4);
            authorRepo.save(author5);
        }
    }
}


