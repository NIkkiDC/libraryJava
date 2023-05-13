package com.library.demo.seed;

import com.library.demo.model.Author;
import com.library.demo.model.Book;
import com.library.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthorData implements CommandLineRunner {

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public void run(String... args) throws Exception {
        dataForAuthor();
    }
    //Long id, String name, String description, String isbn
    private void dataForAuthor () {
        if (authorRepo.count() == 0) {
            Author author1 = new Author("Toni Morrison", "Some description");
            Author author2 = new Author("Alice Walker", "Some description");
            Author author3 = new Author("Octavia E. Butler", "Some description");
            Author author4 = new Author("Maya Angelou", "Some description");
            Author author5 = new Author("Eric Thomas", "Some description");
                    author5.setBookList(Arrays.asList(new Book(1L,"Red Book", "A fiction book","777888777888")));
                    author4.setBookList(Arrays.asList(new Book(4L, "Orange Book", "A fiction Book", "1122112211")));
            authorRepo.save(author1);
            authorRepo.save(author2);
            authorRepo.save(author3);
            authorRepo.save(author4);
            authorRepo.save(author5);
        }
    }
}


