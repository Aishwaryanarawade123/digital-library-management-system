package com.library.digital;

import com.library.digital.model.Book;
import com.library.digital.model.AvailabilityStatus;
import com.library.digital.repository.BookRepository;
import com.library.digital.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BookService class using JUnit and Mockito.
 */
@ExtendWith(MockitoExtension.class) // Enables Mockito support in JUnit 5
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository; // Mocking the BookRepository to avoid actual database interactions

    @InjectMocks
    private BookService bookService; // Injecting the mock repository into the BookService

    /**
     * Test case for adding a book to the library.
     * It verifies that the book is successfully saved and repository's save method is called once.
     */
    @Test
    public void testAddBook() {
        // Creating a sample book
        Book book = new Book(1L, "Java Basics", "John Doe", "Programming", AvailabilityStatus.AVAILABLE);
        
        // Mocking the save method of the repository
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Calling the service method
        Book savedBook = bookService.addBook(book);

        // Validating the results
        assertNotNull(savedBook); // Ensure the saved book is not null
        assertEquals("Java Basics", savedBook.getTitle()); // Ensure the title matches
        verify(bookRepository, times(1)).save(any(Book.class)); // Verify the save method was called once
    }

    /**
     * Test case for retrieving a book by its ID.
     * It verifies that the book is found and returned correctly.
     */
    @Test
    public void testGetBookById() {
        // Creating a sample book
        Book book = new Book(1L, "Java Basics", "John Doe", "Programming", AvailabilityStatus.AVAILABLE);
        
        // Mocking the findById method of the repository
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // Calling the service method
        Optional<Book> retrievedBook = bookService.getBookById(1L);

        // Validating the results
        assertTrue(retrievedBook.isPresent()); // Ensure the book is found
        assertEquals("Java Basics", retrievedBook.get().getTitle()); // Ensure the title matches
        verify(bookRepository, times(1)).findById(1L); // Verify the findById method was called once
    }
}
