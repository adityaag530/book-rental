package com.crio.bookrental.service;
/*
 * @author adityagupta
 * @date 05/04/24
 */


import com.crio.bookrental.entity.Book;
import com.crio.bookrental.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceTest.class);

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRentBook_Success() {
        // Mock data
        Integer bookId = 123;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Sample Book");
        book.setAuthor("Sample Author");
        book.setGenre("Fiction");
        book.setAvailable(true);

        // Mock repository behavior
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        // Call the service method
        Book rentedBook = bookService.rentBook(bookId);

        // Assertions
        assertTrue(!rentedBook.isAvailable());
        assertEquals("Sample Book", rentedBook.getTitle());
    }

    @Test
    public void testReturnBook_Success() {
        // Mock data
        Integer bookId = 123;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Sample Book");
        book.setAuthor("Sample Author");
        book.setGenre("Fiction");
        book.setAvailable(false); // Book is already rented

        // Mock repository behavior
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        // Call the service method
        Book returnedBook = bookService.returnBook(bookId);

        // Assertions
        assertTrue(returnedBook.isAvailable());
        assertEquals("Sample Book", returnedBook.getTitle());
    }
    
}
