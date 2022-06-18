package com.ms.book.service.impl;

import com.ms.book.entity.Book;
import com.ms.book.repo.BookRepo;
import com.ms.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public List<Book> getListBookByAuteurId(Long id) {
        return bookRepo.findBooksByAuteurId(id);
    }
}
