package com.example.spring_mvc_orders_practice.model;

    import java.util.Objects;

    /**
     * Represents a product that can be included in an order.
     *
     * <p>Simple POJO used for JSON (de)serialization by Spring Boot / Jackson.
     * Fields are nullable to keep the model flexible for demo/in-memory usage.
     *
     * <p>Designed to be easy to read for a developer with ~1 year of Java/Spring experience.
     */
    public class Product {

        // Unique identifier for the product (may be null for new, unsaved products).
        private Long id;

        // Human-readable product name.
        private String name;

        // Cost of the product. Use Double to allow null when cost is unknown.
        private Double cost;

        /**
         * Default constructor required by frameworks (Jackson, proxies).
         */
        public Product() {}

        /**
         * All-args constructor for convenience in tests and initialization.
         *
         * @param id product identifier
         * @param name product name
         * @param cost product cost
         */
        public Product(Long id, String name, Double cost) {
            this.id = id;
            this.name = name;
            this.cost = cost;
        }

        /**
         * Get product id.
         *
         * @return id or null if not set
         */
        public Long getId() {
            return id;
        }

        /**
         * Set product id.
         *
         * @param id identifier to set
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * Get product name.
         *
         * @return name or null if not set
         */
        public String getName() {
            return name;
        }

        /**
         * Set product name.
         *
         * @param name name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get product cost.
         *
         * @return cost or null if unknown
         */
        public Double getCost() {
            return cost;
        }

        /**
         * Set product cost.
         *
         * @param cost cost to set
         */
        public void setCost(Double cost) {
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Product product = (Product) o;
            return Objects.equals(id, product.id)
                    && Objects.equals(name, product.name)
                    && Objects.equals(cost, product.cost);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, cost);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }