package com.example.spring_mvc_orders_practice.repository;

    import com.example.spring_mvc_orders_practice.model.Order;
    import org.springframework.stereotype.Repository;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Objects;

    /**
     * Simple in-memory repository for Order entities.
     *
     * <p>This class is intentionally minimal and intended for demo or practice projects.
     * It uses an in-memory list and provides basic get/add operations.
     *
     * <p>Methods synchronize on the internal list to provide simple thread-safety
     * and return defensive copies where appropriate.
     */
    @Repository
    public class OrderRepository {

        // Internal storage for orders (in-memory).
        private final List<Order> orders = new ArrayList<>();

        /**
         * Retrieve an order by its id.
         *
         * @param id identifier of the order (may be null)
         * @return found Order or null if not found or if id is null
         */
        public Order getOrderById(Long id) {
            if (id == null) {
                return null;
            }
            // Synchronize access to avoid concurrent modification issues.
            synchronized (orders) {
                return orders.stream()
                        // guard against null entries and use Objects.equals to avoid NPEs
                        .filter(o -> o != null && Objects.equals(o.getId(), id))
                        .findFirst()
                        .orElse(null);
            }
        }

        /**
         * Return all orders.
         *
         * @return a defensive copy of the orders list (may be empty)
         */
        public List<Order> getAllOrders() {
            synchronized (orders) {
                // Return a new list to prevent callers from modifying internal state.
                return new ArrayList<>(orders);
            }
        }

        /**
         * Add a new order to the repository.
         *
         * @param order order to add (ignored if null)
         */
        public void addOrder(Order order) {
            if (order == null) {
                return;
            }
            synchronized (orders) {
                orders.add(order);
            }
        }
    }