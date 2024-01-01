package com.library.library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.Entity.book;
import com.library.library.Entity.user;
import com.library.library.Repository.BookRepository;
import com.library.library.Repository.UserRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<book> findAll() {
        return bookRepository.findAll();
    }

    
    public book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public book save(book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public book borrowBook(Long bookId, Long userId) {
        book book = findById(bookId);
        user user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }

    public book returnBook(Long bookId) {
        book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }
}







    

