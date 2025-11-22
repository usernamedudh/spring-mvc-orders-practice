package com.example.spring_mvc_orders_practice.controller;

import com.example.spring_mvc_orders_practice.model.Order;
import com.example.spring_mvc_orders_practice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller that exposes CRUD endpoints for orders.
 *
 * <p>This controller delegates data operations to {@link OrderRepository}.
 * Methods use simple types (Order, List\<Order\>) so Spring will handle JSON
 * (de)serialization automatically via Jackson.
 *
 * <p>Designed to be easy to read for a developer with ~1 year of Java/Spring experience.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    // Repository that provides access to order data (in-memory or persistent).
    private final OrderRepository repository;

    /**
     * Constructor injection is preferred for required dependencies.
     *
     * @param repository repository that manages Order entities
     */
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve a single order by its id.
     *
     * <p>Example: GET /orders/1
     *
     * @param id identifier of the order
     * @return the found Order or null (depending on repository implementation)
     */
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        // Delegate to repository to find the order by id.
        return repository.getOrderById(id);
    }

    /**
     * Retrieve all orders.
     *
     * <p>Example: GET /orders
     *
     * @return list of all orders (may be empty)
     */
    @GetMapping
    public List<Order> getAll() {
        // Return all orders from repository.
        return repository.getAllOrders();
    }

    /**
     * Create a new order.
     *
     * <p>Example: POST /orders with JSON body of Order
     *
     * @param order order data from request body (JSON -> Order)
     * @return simple message indicating result (consider returning created entity or proper HTTP status in real apps)
     */
    @PostMapping
    public String addOrder(@RequestBody Order order) {
        // Save the order using the repository.
        repository.addOrder(order);
        // Returning a plain string for simplicity; in production prefer ResponseEntity with CREATED status.
        return "Order added successfully";
    }
}