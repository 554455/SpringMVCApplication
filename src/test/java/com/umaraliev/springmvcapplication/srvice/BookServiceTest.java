package com.umaraliev.springmvcapplication.srvice;

import com.umaraliev.springmvcapplication.model.Book;
import com.umaraliev.springmvcapplication.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository = mock(BookRepository.class);

    @InjectMocks
    private BookService bookService = new BookService(bookRepository);
    private Book book;

    @Test
    void getById() {

        book = new Book();
        Book getByIdBook = new Book();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(getByIdBook);

        when(bookRepository.getById(1L)).thenReturn(book);
    }

    @Test
    void getAll() {
        book = new Book();
        Book getByIdBook = new Book();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(getByIdBook);

        when(bookRepository.findAll()).thenReturn(bookList);
    }

    @Test
    void save() {

        book = new Book();

        book.setName("active spring");
        book.setPrice(2_000);

        when(bookRepository.save(any(Book.class))).thenReturn(book);
        assertEquals("active spring", book.getName());
    }

    @Test
    void delete() {
        bookRepository.deleteById(anyLong());

        verify(bookRepository).deleteById(anyLong());
    }
}