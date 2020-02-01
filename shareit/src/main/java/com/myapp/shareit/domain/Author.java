package com.myapp.shareit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String first_name;

    private String last_name;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")})
    private Set<Book> books;
}
