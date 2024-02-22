package com.workintech.library.service;

import com.workintech.library.entity.Book;

public interface BookService {

    Book findById(long id);

    Book save(Book book);
}
