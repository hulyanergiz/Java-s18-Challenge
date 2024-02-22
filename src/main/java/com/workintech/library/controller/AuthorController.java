package com.workintech.library.controller;

import com.workintech.library.dto.AuthorBookResponse;
import com.workintech.library.dto.AuthorResponse;
import com.workintech.library.dto.BookResponse;
import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    private final BookService bookService;

    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.save(author);

    }
    @PostMapping("/{bookId}")
    public AuthorBookResponse save(@RequestBody Author author, @PathVariable long bookId){
        Book foundBook=bookService.findById(bookId);
        author.addBook(foundBook);
        authorService.save(author);
        List<BookResponse> bookResponseList=new ArrayList<>();
        for(Book authorBook: author.getBooks()){
            bookResponseList.add(new BookResponse(authorBook.getId(),authorBook.getName(),authorBook.getCategory().getName(),new AuthorResponse(author.getId(), author.getFirstName()+" "+author.getLastName())));
        }
        return new AuthorBookResponse(bookResponseList);
    }


}
