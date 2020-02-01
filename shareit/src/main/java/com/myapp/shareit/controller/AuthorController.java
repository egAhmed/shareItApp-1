package com.myapp.shareit.controller;

import com.myapp.shareit.domain.Author;
import com.myapp.shareit.exceptions.AuthorNotFoundException;
import com.myapp.shareit.repository.AuthorRepository;
import com.myapp.shareit.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private AuthorRepository authorRepository;

    public AuthorController(AuthorService authorService, AuthorRepository authorRepository){
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAllAuhtors(){
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return authorService.getAuthor(id);
    }
    @PostMapping
    public void createAuthor(@Valid @RequestBody Author author){
        authorService.createAuthor(author);
    }

    @PutMapping
    public void updateAuthor(@RequestBody Author author){
        Optional<Author> authorOptional = authorRepository.findById(author.getId());

       if (authorOptional.isPresent()){
           authorService.updateAuthor(author);
       }
       else{
           throw  new AuthorNotFoundException("Auhtor not found");
       }
    }
    @DeleteMapping("/{id}")
    public void deleteAuhtor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @PutMapping("/{author_id}/book/{book_id}")
    public void addAuhtorToBook(@PathVariable(value = "author_id")Long author_id, @PathVariable(value = "book_id") Long book_id){
        authorService.addBookToAuthor(author_id,book_id);
    }

}
