package com.example.spring_mvc_orders_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application entry point for the orders practice project.
 *
 * <p>Запускает встроенный Spring контейнер и поднимает веб-приложение.
 */
@SpringBootApplication
public class SpringMvcOrdersPracticeApplication {

    /**
     * Application entry point.
     *
     * @param args стартовые аргументы (передаются SpringApplication)
     */
    public static void main(String[] args) {
        // Запуск Spring Boot приложения. SpringApplication.run вернёт контекст приложения.
        SpringApplication.run(SpringMvcOrdersPracticeApplication.class, args);
    }

}