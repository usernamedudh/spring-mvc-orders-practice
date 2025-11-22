package com.example.spring_mvc_orders_practice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

    /**
     * Represents an order placed by a customer.
     *
     * <p>This POJO is intentionally simple: it holds basic order metadata and a list of
     * products. JSON (de)serialization is handled by Spring Boot / Jackson when this
     * object is used as a request or response body.
     *
     * <p>Designed to be easy to read for a developer with ~1 year of Java/Spring experience.
     */
public class Order {

// Unique identifier for the order (may be null for new orders not yet persisted).
private Long id;

    // When the order was created.
    private LocalDateTime creationDate;

    // Cached total cost of the order. Keep Double to allow null if unknown.
    private Double totalCost;

    // List of products included in the order.
    private List<Product> products;

    /**
     * Default constructor required by frameworks (Jackson, JPA proxies, etc.).
     */
    public Order() {}

    /**
     * Convenience constructor to create an Order with all fields.
     *
     * @param id identifier of the order
     * @param creationDate timestamp when the order was created
     * @param totalCost precomputed total cost of the order
     * @param products list of products in the order
     */
    public Order(Long id, LocalDateTime creationDate, Double totalCost, List<Product> products) {
        this.id = id;
        this.creationDate = creationDate;
        this.totalCost = totalCost;
        this.products = products;
    }

    /**
     * Get the order id.
     *
     * @return id or null if not set
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the order id.
     *
     * @param id identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get creation timestamp.
     *
     * @return creation date-time
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Set creation timestamp.
     *
     * @param creationDate date-time to set
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Get total cost.
     *
     * @return total cost or null if unknown
     */
    public Double getTotalCost() {
        return totalCost;
    }

    /**
     * Set total cost.
     *
     * @param totalCost total amount for the order
     */
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Get products in the order.
     *
     * @return list of products (may be null or empty)
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Set products for the order.
     *
     * @param products list of products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return Objects.equals(id, order.id)
                && Objects.equals(creationDate, order.creationDate)
                && Objects.equals(totalCost, order.totalCost)
                && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, totalCost, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", totalCost=" + totalCost +
                ", products=" + products +
                '}';
    }
}