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
@Table(name="category", schema="fsweb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="category")
    private List<Book> books;

    public void addBook(Book book){
        if(books==null){
            books=new ArrayList<>();
        }
        books.add(book);
    }
}
