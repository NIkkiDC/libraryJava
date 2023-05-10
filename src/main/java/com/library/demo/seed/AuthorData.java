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
            Author author1 = new Author("Toni Morrison", "Some description");
            Author author2 = new Author("Alice Walker", "Some description");
            Author author3 = new Author("Octavia E. Butler", "Some description");
            Author author4 = new Author("Maya Angelou", "Some description");
            Author author5 = new Author("Eric Thomas", "Some description");


