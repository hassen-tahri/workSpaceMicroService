package com.ms.book.controller;

import com.ms.book.entity.Book;
import com.ms.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/Create")
    public Object addBook(@RequestBody Book book)
    {
        book = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


    @DeleteMapping("/Delete/{id}")
    public Object deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }


    @GetMapping("/GetById/{id}")
    public Object getById(@PathVariable Long id)
    {
        Book book = bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }


    @GetMapping("/GetAll")
    public Object getAll() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/GetByAuteurId/{id}")
    public Object getByAuteurId(@PathVariable Long id) {
        List<Book> books = bookService.getListBookByAuteurId(id);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
}
