package com.workintech.library.service;

import com.workintech.library.entity.Author;

public interface AuthorService {

    Author findById(long id);

    Author save(Author author);
}
