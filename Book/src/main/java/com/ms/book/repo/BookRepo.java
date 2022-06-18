package com.ms.book.repo;

import com.ms.book.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {
    List<Book> findBooksByAuteurId(Long id);
}
