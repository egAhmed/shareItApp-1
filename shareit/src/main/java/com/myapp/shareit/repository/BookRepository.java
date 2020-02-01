package com.myapp.shareit.repository;

import com.myapp.shareit.domain.Author;
import com.myapp.shareit.domain.Book;
import com.myapp.shareit.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String bookTitle);

    //List<Book> findByIsAvailable(Boolean isAvailable);
    List<Book> findByOwner_Id(Long userId);

    List<Book> findByCategories(Category category);

    List<Book> findByAuthors(Author author);



}
