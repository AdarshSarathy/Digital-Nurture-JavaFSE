package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main entry point.
 *
 * Loads the Spring application context from applicationContext.xml,
 * retrieves the BookService bean, and tests the configuration
 * along with the dependency injection of BookRepository.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load the Spring application context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the context
        BookService bookService = context.getBean("bookService", BookService.class);

        // ---------------------------------------------------------------
        // Exercise 1: Verify that the Spring context loads correctly
        // ---------------------------------------------------------------
        System.out.println("=== Exercise 1: Spring Application Context Loaded ===");
        System.out.println("BookService bean retrieved: " + (bookService != null));
        System.out.println();

        // ---------------------------------------------------------------
        // Exercise 2: Verify Dependency Injection
        // BookRepository should have been injected into BookService
        // ---------------------------------------------------------------
        System.out.println("=== Exercise 2: Dependency Injection Verification ===");
        System.out.println("BookRepository injected: " + (bookService.getBookRepository() != null));
        System.out.println();

        // ---------------------------------------------------------------
        // Test service operations
        // ---------------------------------------------------------------
        System.out.println("=== Testing BookService Operations ===");
        bookService.getAllBooks();
        System.out.println();

        bookService.getBookById(1);
        System.out.println();

        bookService.addBook("Spring in Action");
        System.out.println();

        bookService.removeBook(1);

        // Close the context to prevent resource leak
        ((ClassPathXmlApplicationContext) context).close();
    }
}
