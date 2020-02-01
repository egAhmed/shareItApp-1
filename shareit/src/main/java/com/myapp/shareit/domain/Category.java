package com.myapp.shareit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "category_book",
            joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")})
    private Set<Book> books;
}
