package com.workintech.library.controller;

import com.workintech.library.dto.AuthorResponse;
import com.workintech.library.dto.BookResponse;
import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.entity.Category;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;
import com.workintech.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId){
        Category category=categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), category.getName(),null);
    }
    @PostMapping("/saveByAuthor")
    public BookResponse save(@RequestBody Book book,@RequestParam long categoryId, @RequestParam long authorId){
       Category category=categoryService.findById(categoryId);
       book.setCategory(category);
       category.addBook(book);

       Author author=authorService.findById(authorId);
       book.setAuthor(author);
       author.addBook(book);

       bookService.save(book);

       return new BookResponse(book.getId(), book.getName(), category.getName(), new AuthorResponse(authorId, author.getFirstName()+" "+author.getLastName()));
    }
}
