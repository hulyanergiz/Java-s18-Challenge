package com.workintech.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="author",schema="fsweb")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="author")
    private List<Book> books;

    public void addBook(Book book){
        if(books==null){
            books=new ArrayList<>();
        }
        books.add(book);
    }
}
