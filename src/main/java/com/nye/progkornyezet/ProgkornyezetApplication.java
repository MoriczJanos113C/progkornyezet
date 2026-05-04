package com.nye.progkornyezet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication
public final class ProgkornyezetApplication {

    private ProgkornyezetApplication() {
        // not allowing object creation
    }

    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ProgkornyezetApplication.class, args);
    }

}
