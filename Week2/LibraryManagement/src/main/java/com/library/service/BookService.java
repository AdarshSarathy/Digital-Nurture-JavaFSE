package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookService - Business logic layer for managing books.
 * Depends on BookRepository for data access operations.
 *
 * Exercise 2: BookRepository is injected via setter-based Dependency Injection
 * configured in applicationContext.xml.
 */
public class BookService {

    private BookRepository bookRepository;

    // ---------------------------------------------------------------
    // Exercise 2: Setter method for Dependency Injection
    // Spring uses this setter to wire BookRepository into BookService
    // ---------------------------------------------------------------

    /**
     * Setter for BookRepository (used by Spring for DI).
     *
     * @param bookRepository the BookRepository instance to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Returns the injected BookRepository instance.
     *
     * @return the BookRepository
     */
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    // ---------------------------------------------------------------
    // Service methods delegating to the repository
    // ---------------------------------------------------------------

    /**
     * Retrieves all books.
     */
    public void getAllBooks() {
        System.out.println("BookService: Getting all books...");
        bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book
     */
    public void getBookById(int id) {
        System.out.println("BookService: Getting book by ID...");
        bookRepository.findById(id);
    }

    /**
     * Adds a new book.
     *
     * @param title the title of the book to add
     */
    public void addBook(String title) {
        System.out.println("BookService: Adding a new book...");
        bookRepository.save(title);
    }

    /**
     * Removes a book by its ID.
     *
     * @param id the ID of the book to remove
     */
    public void removeBook(int id) {
        System.out.println("BookService: Removing book...");
        bookRepository.delete(id);
    }
}
