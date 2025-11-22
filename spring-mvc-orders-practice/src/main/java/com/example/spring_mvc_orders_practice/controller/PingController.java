package com.example.spring_mvc_orders_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple health check REST controller.
 *
 * <p>Exposes a single GET endpoint {@code /ping} that returns a plain "OK"
 * response. Useful for readiness/liveness checks or quick connectivity tests.
 *
 * <p>Designed to be easy to read for a developer with ~1 year of Java/Spring experience.
 */
@RestController
public class PingController {

    /**
     * Health check endpoint.
     *
     * <p>Example: GET /ping
     *
     * @return a plain "OK" string (Spring will return HTTP 200 by default)
     */
    @GetMapping("/ping")
    public String ping() {
        // Return a simple status string. In real apps consider returning a DTO or using ResponseEntity.
        return "OK";
    }
}