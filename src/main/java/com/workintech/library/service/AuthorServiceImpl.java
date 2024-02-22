package com.workintech.library.service;

import com.workintech.library.entity.Author;
import com.workintech.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional=authorRepository.findById(id);
        return authorOptional.orElseThrow(()->new RuntimeException("Author is not found with id: "+id));
    }

    @Override
    public Author save(Author author) {
        Optional<Author> authorOptional=authorRepository.findById(author.getId());
        if(authorOptional.isPresent()){
            throw new RuntimeException("Author already exist");
        }
        return authorRepository.save(author);
    }
}
