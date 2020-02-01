package com.myapp.shareit.service;

import com.myapp.shareit.domain.Author;
import com.myapp.shareit.domain.Book;
import com.myapp.shareit.exceptions.AuthorNotFoundException;
import com.myapp.shareit.exceptions.BookNotFoundException;
import com.myapp.shareit.repository.AuthorRepository;
import com.myapp.shareit.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository){
        this.bookRepository = bookRepository;
        this.authorRepository=authorRepository;
    }

    public Optional<Author> getAuthor(Long id){
        return authorRepository.findById(id);
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.findById(id).ifPresent(authorRepository::delete);
    }

    public void addBookToAuthor(Long author_id, Long book_id){
        Book book = bookRepository.findById(book_id).orElseThrow(()->new BookNotFoundException("Book not found"));
        Author author = authorRepository.findById(author_id).orElseThrow(()-> new AuthorNotFoundException("Author not found"));
        author.getBooks().add(book);
        authorRepository.save(author);

    }
}
