package com.library.demo.seed;
import com.library.demo.model.Book;
import com.library.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookData  implements CommandLineRunner {

    @Autowired
    BookRepo bookRepo;

    @Override
    public void run(String... args) throws Exception {
        dataForBook();
    }

    private void dataForBook() {
        if (bookRepo.count() == 0) {
            Book book1 = new Book(1L, "Freat Gatsby", "Folk tale", "122122122");
            Book book2 = new Book(2L, "Freat Gatsby", "Folk tale", "122122122");
            Book book3 = new Book(3L, "Freat Gatsby", "Folk tale", "122122122");
            Book book4 = new Book(4L, "Freat Gatsby", "Folk tale", "122122122");
            Book book5 = new Book(5L, "Freat Gatsby", "Folk tale", "122122122");

            bookRepo.save(book1);
            bookRepo.save(book2);
            bookRepo.save(book3);
            bookRepo.save(book4);
            bookRepo.save(book5);
        }
    }
}

