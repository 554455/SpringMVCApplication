package com.umaraliev.springmvcapplication.srvice;

import com.umaraliev.springmvcapplication.model.Book;
import com.umaraliev.springmvcapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
