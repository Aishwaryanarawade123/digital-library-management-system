package com.library.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.digital.model.Book;

import java.util.Optional;

/**
 * Repository interface for managing Book entities in the database.
 * Extends JpaRepository to provide built-in CRUD operations.
 */
@Repository  // Marks this interface as a Spring Data repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Custom query method to find a book by its title.
     * @param title The title of the book.
     * @return An Optional containing the book if found, otherwise empty.
     */
    Optional<Book> findByTitle(String title);
}
