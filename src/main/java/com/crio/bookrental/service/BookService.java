package com.crio.bookrental.service;

import com.crio.bookrental.entity.Book;
import com.crio.bookrental.repository.BookRepository;
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

    @Autowired
    BookRepository bookRepository;

    public Book rentBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.isAvailable()) {
                book.setAvailable(false);
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("Book is not available for rent");
            }
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public Book returnBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (!book.isAvailable()) {
                book.setAvailable(true);
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("Book is already returned");
            }
        } else {
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
