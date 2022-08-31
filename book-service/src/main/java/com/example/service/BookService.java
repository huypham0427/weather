package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> listAll(){
        return repo.findAll();
    }

    public void save(Book book){
        repo.save(book);
    }

    public Book get(Integer id){
        return repo.findById(id).get();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
