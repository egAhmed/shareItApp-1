package com.myapp.shareit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String firstName;

    private String lastName;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")})
    private Set<Book> books;
}
