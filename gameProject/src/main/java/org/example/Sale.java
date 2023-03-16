package org.example;

public class Sale {
    private int id;
    private Order order;

    public Sale(int id, Order order) {
        this.id = id;
        this.order = order;
    }

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
