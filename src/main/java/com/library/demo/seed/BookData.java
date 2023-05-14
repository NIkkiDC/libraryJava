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
                    "From Nobel Laureate Toni Morrison comes the story of a young black girl who longs to" +
                            " be like the blond, blue-eyed children that America loves-a novel \"so charged with pain and " +
                            "wonder that it becomes poetry\" (The New York Times).",
                    "0452282195");
            Book book2 = new Book(2L, "The Color Purple",
                    "Alice Walker's iconic modern classic is now a Penguin Book. A powerful cultural touchstone " +
                            "of modern American literature, The Color Purple depicts the lives of African American women " +
                            "in early twentieth-century rural Georgia. ",
                    " 0671727796");
            Book book3 = new Book(3L, "Kindred",
                    "The visionary time-travel classic whose Black female hero is pulled through time to face the" +
                            " horrors of American slavery and explores the impacts of racism, sexism, and white supremacy then and now",
                    "1538732181");
            Book book4 = new Book(4L, "I Know Why The Caged Bird Sings",
                    "Here is a book as joyous and painful, as mysterious and memorable, as childhood itself. I Know Why " +
                            "the Caged Bird Sings captures the longing of lonely children, the brute insult of bigotry, and the wonder" +
                            " of words that can make the world right.",
                    "0553122525");
            Book book5 = new Book(5L, "You Owe You",
                    "\"You Owe You is full of insight and guidance for those seeking their inner selves.\"--MICHAEL B. JORDAN " +
                            "No matter your story or your struggle, Eric Thomas--celebrated motivational guru, educator, and problem-solver" +
                            " to many of the top athletes and business leaders--will \"help you work harder, discover your real motivation, " +
                            "and crack the code of enduring success\" ",
                    "0593234987");

            bookRepo.save(book1);
            bookRepo.save(book2);
            bookRepo.save(book3);
            bookRepo.save(book4);
            bookRepo.save(book5);
        }
    }
}

