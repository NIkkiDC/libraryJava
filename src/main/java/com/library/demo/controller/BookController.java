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

//    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category categoryObject) {
//        return categoryService.updateCategory(categoryId, categoryObject);
//    }

    @Autowired
    private BookService bookService;

    @GetMapping("/books/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

//    @PutMapping(path = "/books/{bookId}/")
//    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
//
//        Optional<Book> book1 = bookService.findById(bookId);
//
//        if (book1.isPresent()) {
//            Book book2 = book1.get();
//            book2.setName(book.getName());
//            book2.setDescription(book.getDescription());
//            book2.setIsbn(book.getIsbn());
//            return bookService.save(book2);
//        } else {
//            throw new InformationExistException("Book with id " + bookId + " not found");
//        }
//    }
}

