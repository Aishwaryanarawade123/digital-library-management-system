package com.library.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.digital.model.Book;
import com.library.digital.service.BookService;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling book-related operations in the Digital Library Management System.
 */
@RestController
@RequestMapping("/books")  // Base URL for all book-related endpoints
public class BookController {

    @Autowired
    private BookService bookService; // Injecting BookService for business logic

    /**
     * Fetch all books from the database.
     * @return List of all books.
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Fetch a book by its unique ID.
     * @param id The ID of the book.
     * @return The book with the given ID (if found).
     */
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    /**
     * Fetch a book by its title.
     * @param title The title of the book.
     * @return The book with the given title (if found).
     */
    @GetMapping("/title/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    /**
     * Add a new book to the library.
     * @param book The book object to be added.
     * @return The saved book object.
     */
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    /**
     * Update an existing book by ID.
     * @param id The ID of the book to update.
     * @param book The updated book object.
     * @return The updated book.
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    /**
     * Delete a book from the library.
     * @param id The ID of the book to delete.
     * @return Confirmation message after deletion.
     */
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}
