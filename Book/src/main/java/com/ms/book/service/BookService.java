package com.ms.book.service;

import com.ms.book.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    void deleteBook(Long id);
    List<Book> getAllBook();
    Book getById(Long id);
    List<Book> getListBookByAuteurId(Long id);

}
