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
            Book book1 = new Book(1L, "The Bluest Eye",
                    "Novel/ Fiction",
                    "0452282195");
            Book book2 = new Book(2L, "The Color Purple",
                    "Epistolary novel",
                    " 0671727796");
            Book book3 = new Book(3L, "Kindred",
                    "Novel",
                    "1538732181");
            Book book4 = new Book(4L, "I Know Why The Caged Bird Sings",
                    "Autobiography",
                    "0553122525");
            Book book5 = new Book(5L, "You Owe You",
                    "Motivational",
                    "0593234987");

            bookRepo.save(book1);
            bookRepo.save(book2);
            bookRepo.save(book3);
            bookRepo.save(book4);
            bookRepo.save(book5);
        }
    }
}

