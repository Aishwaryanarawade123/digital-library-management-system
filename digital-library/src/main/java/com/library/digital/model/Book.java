package com.library.digital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * Entity class representing a Book in the Digital Library Management System.
 */
@Entity  // Marks this class as a JPA entity
@Table(name = "books")  // Maps this entity to the "books" table in the database
public class Book {
    
    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID value
    private Long id;
    
    @NotEmpty(message = "Title is required")  // Ensures the title field is not empty
    private String title;
    
    @NotEmpty(message = "Author is required")  // Ensures the author field is not empty
    private String author;
    
    private String genre;  // Genre of the book (optional)
    
    @Enumerated(EnumType.STRING)  // Stores the enum as a String in the database
    private AvailabilityStatus availabilityStatus;  // Status of book availability
   
    /**
     * No-argument constructor (Required for JPA).
     */
    public Book() {}

    /**
     * Parameterized constructor to initialize book attributes.
     * @param id Unique identifier of the book.
     * @param title Title of the book.
     * @param author Author of the book.
     * @param genre Genre of the book.
     * @param availabilityStatus Availability status of the book.
     */
    public Book(Long id, String title, String author, String genre, AvailabilityStatus availabilityStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters & Setters for accessing and modifying book properties

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public AvailabilityStatus getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}
