package com.workintech.library.service;

import com.workintech.library.entity.Book;
import com.workintech.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        return bookOptional.orElseThrow(()->new RuntimeException("Book is not found with id: "+id));
    }

    @Override
    public Book save(Book book) {
        Optional<Book> bookOptional=bookRepository.findById(book.getId());
        if(bookOptional.isPresent()){
            throw new RuntimeException("Book already exist");
        }
        return bookRepository.save(book);
    }
}
