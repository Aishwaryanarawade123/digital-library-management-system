package com.library.digital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

/**
 * Controller to handle system exit operations for the Digital Library Management System.
 */
@RestController  // Marks this class as a REST controller
@RequestMapping("/system")  // Base URL mapping for this controller
public class ExitController {
	
    /**
     * This method is executed when the controller is initialized.
     * It prints a message indicating that the controller has been loaded successfully.
     */
    @PostConstruct
    public void init() {
        System.out.println("ExitController Loaded Successfully!");
    }

    /**
     * Handles a GET request to "/system/exit".
     * When accessed, it prints a shutdown message and terminates the application.
     * 
     * @return A shutdown message (this return statement won't actually execute).
     */
    @GetMapping("/exit")
    public String exitSystem() {
        System.out.println("Shutting down the Digital Library System...");
        System.exit(0);  // Terminates the entire application
        return "System is shutting down...";  // This line is unreachable
    }
}
