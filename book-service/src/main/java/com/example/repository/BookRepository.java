package com.example.repository;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
//    Book listAll();
//    Book save(Book book);
//    Book get(Integer id);
//    Book delete(Integer id);
}
