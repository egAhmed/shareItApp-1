package com.myapp.shareit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @NotEmpty(message = "*Please provide a title")
    private String title;

    private String description;

    private String isbn_code;

    private boolean isAvailable;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    private User owner;


    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;


    @ManyToMany(mappedBy = "books")
    private Set<Category> categories;
/*

    @OneToMany(mappedBy = "books")
    private Set<Rental> rentals;
*/




}
