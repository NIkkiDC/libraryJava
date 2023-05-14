package com.library.demo.controller;
import com.library.demo.exception.InformationExistException;
import com.library.demo.model.Book;
import com.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/books/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PutMapping(path = "/books/{bookId}/")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {

        Optional<Book> book1 = bookService.findById(bookId);

        if (book1.isPresent()) {
            Book book2 = book1.get();
            book2.setName(book.getName());
            book2.setDescription(book.getDescription());
            book2.setIsbn(book.getIsbn());
            return bookService.save(book2);
        } else {
            throw new InformationExistException("Book with id " + bookId + " not found");
        }
    }
        @DeleteMapping(path = "books/{bookId}/")
        public void deleteBook(@PathVariable(value = "bookId") Long bookId){
            Optional<Book> book = bookService.findById(bookId);
            if (book.isPresent()){

                Book BookToDelete = book.get();
                bookService.delete(BookToDelete);
            }
            else {
                throw new InformationExistException("Book with id "+bookId+" not found");
            }
        }
    }

