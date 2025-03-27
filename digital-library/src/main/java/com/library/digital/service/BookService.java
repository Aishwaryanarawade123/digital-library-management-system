package com.library.digital.service;

import com.library.digital.model.Book;
import com.library.digital.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing books in the Digital Library System.
 * It handles business logic and interacts with the BookRepository.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;  // Injecting the BookRepository for database operations

    /**
     * Retrieves all books from the library.
     * @return List of all books.
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     * @param id The ID of the book.
     * @return An Optional containing the book if found, otherwise empty.
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Retrieves a book by its title.
     * @param title The title of the book.
     * @return An Optional containing the book if found, otherwise empty.
     */
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    /**
     * Adds a new book to the library.
     * @param book The book to be added.
     * @return The saved book.
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Updates an existing book's details.
     * @param id The ID of the book to be updated.
     * @param updatedBook The new book details.
     * @return The updated book.
     * @throws RuntimeException if the book is not found.
     */
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
            return bookRepository.save(book); // Save the updated book
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    /**
     * Deletes a book from the library.
     * @param id The ID of the book to be deleted.
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
