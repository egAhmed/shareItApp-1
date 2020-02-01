package com.myapp.shareit.service;

import com.myapp.shareit.domain.Book;
import com.myapp.shareit.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
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
        bookRepository.save(book);
    }
    public void deleteBook(Long id){
        //verific daca user e owner
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }

    public void addBookToCategory(Long book_id,Long category_id){

    }
    //public List<Book> getBookByCategory(Long category_id){}

    //public List<Book> getBookByOwner(Long owner_id){}

    //public List<Book> getBookByTitle(Long category_id){}

    //public List<Book> getAvailableBooks(Long category_id){}

}
