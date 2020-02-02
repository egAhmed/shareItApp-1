package com.myapp.shareit.service;

import com.myapp.shareit.domain.Author;
import com.myapp.shareit.domain.Book;
import com.myapp.shareit.domain.Category;
import com.myapp.shareit.exceptions.AuthorNotFoundException;
import com.myapp.shareit.exceptions.BookNotFoundException;
import com.myapp.shareit.exceptions.CategoryNotFoundException;
import com.myapp.shareit.repository.AuthorRepository;
import com.myapp.shareit.repository.BookRepository;
import com.myapp.shareit.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook (Long id){
        return bookRepository.findById(id);
    }

    public void createBook(Book book){
        //verific daca user e logat
        bookRepository.save(book);
    }
    public void updateBook(Book book){
        //verific daca user e owner
        Book updatedBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        bookRepository.save(updatedBook);
    }
    public void deleteBook(Long id){
        //verific daca user e owner
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }

    public void addBookToCategory(Long book_id, Long category_id){
        Category category = categoryRepository.findById(category_id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        Book book = bookRepository.findById(book_id).orElseThrow(() ->
                new BookNotFoundException("Book not found"));
        category.getBooks().add(book);
        categoryRepository.save(category);

    }

    public void addAuthorToBook(Long book_id, Long author_id) {
        Author author = authorRepository.findById(author_id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        Book book = bookRepository.findById(book_id).orElseThrow(() ->
                new BookNotFoundException("Book not found"));
        author.getBooks().add(book);
        log.info("Book with id: " + book_id + " has new author with id: " + authorRepository.save(author).getId());

    }

    public List<Book> getBooksByCategory(String category_name) {
        Category category = categoryRepository.findByName(category_name)
                .orElseThrow(() -> new CategoryNotFoundException("Category " + category_name
                        + " not found"));

        List<Book> books = bookRepository.findByCategories(category);
        if (books == null || books.isEmpty()) {
            throw new BookNotFoundException("No books found from category " + category_name);
        }
        return books;
    }


    public List<Book> getBooksByOwner(Long owner_id) {
        List<Book> books = bookRepository.findByOwner_Id(owner_id);
        if (books == null || books.isEmpty()) {
            throw new BookNotFoundException("User " + owner_id + "has no books registered");
        }
        return books;
    }

    public List<Book> getBooksByTitle(String bookTitle) {
        List<Book> books = bookRepository.findByTitle(bookTitle);
        if (books == null || books.isEmpty()) {
            throw new BookNotFoundException("Book with title " + bookTitle + " not found");
        }
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> books = bookRepository.findByAvailableTrue();
        if (books==null || books.isEmpty()){
            throw new BookNotFoundException("No books available");
        }
        return books;
    }

    public List<Book> getBooksByAuthor(String firstName, String lastName) {
        Author author = authorRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new AuthorNotFoundException("No author with first name " +
                        firstName + " and last name " + lastName));
        List<Book> books = bookRepository.findByAuthors(author);
        if (books == null || books.isEmpty()) {
            throw new BookNotFoundException("No books from this author");
        }
        return books;
    }



}
