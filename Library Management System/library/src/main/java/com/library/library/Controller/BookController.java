package com.library.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Entity.book;
import com.library.library.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
     @Autowired
    private BookService bookService;

    @GetMapping
    public List<book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public book addBook(@RequestBody book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public book updateBook(@PathVariable Long id, @RequestBody book book) {
        // Additional logic to ensure you're updating the correct book
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<book> returnBook(@PathVariable Long bookId) {
        book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}

    

