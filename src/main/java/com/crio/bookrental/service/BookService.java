package com.crio.bookrental.service;

import com.crio.bookrental.entity.Book;
import com.crio.bookrental.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * @author adityagupta
 * @date 05/04/24
 */
@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    BookRepository bookRepository;

    public Book rentBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.isAvailable()) {
                book.setAvailable(false);
                logger.info("Renting book: {}", book.getTitle());
                return bookRepository.save(book);
            } else {
                logger.warn("Book {} is not available for rent", book.getTitle());
                throw new RuntimeException("Book is not available for rent");
            }
        } else {
            logger.error("Book with ID {} not found", id);
            throw new RuntimeException("Book not found");
        }
    }

    public Book returnBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (!book.isAvailable()) {
                book.setAvailable(true);
                logger.info("Returning book: {}", book.getTitle());
                return bookRepository.save(book);
            } else {
                logger.warn("Book {} is already returned", book.getTitle());
                throw new RuntimeException("Book is already returned");
            }
        } else {
            logger.error("Book with ID {} not found", id);
            throw new RuntimeException("Book not found");
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
