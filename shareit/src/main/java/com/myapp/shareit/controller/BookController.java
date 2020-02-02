package com.myapp.shareit.controller;

import com.myapp.shareit.domain.Book;
import com.myapp.shareit.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getById(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public void createBook(@Valid @RequestBody Book book) {
        bookService.createBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{book_id}/category/{category_id}")
    public void addBookToCategory(@PathVariable Long book_id, @PathVariable Long category_id) {
        bookService.addBookToCategory(book_id, category_id);
    }

    @PutMapping("/{book_id}/author/{author_id}")
    public void addAuthorToBook(@PathVariable Long book_id, @PathVariable Long author_id) {
        bookService.addAuthorToBook(book_id, author_id);
    }

    @GetMapping("/category/{category_name}")
    public List<Book> getBooksByCategory(@PathVariable String category_name) {
        return bookService.getBooksByCategory(category_name);
    }

    @GetMapping("/owner/{owner_id}")
    public List<Book> getBooksByOwner(@PathVariable Long owner_id) {
        return bookService.getBooksByOwner(owner_id);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/available")
    public List<Book> getBooksAvailable() {
        return bookService.getAvailableBooks();
    }

    @GetMapping("/author/{first_name}/{last_name}")
    public List<Book> getBooksByAuthor(@PathVariable String first_name, @PathVariable String last_name) {
        return bookService.getBooksByAuthor(first_name, last_name);
    }


}
