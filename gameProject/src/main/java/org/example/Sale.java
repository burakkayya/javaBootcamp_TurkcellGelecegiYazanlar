package org.example;

public class Sale {
    private int id;
    private Cart order;

    public Sale(int id, Cart order) {
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

    public Cart getOrder() {
        return order;
    }

    public void setOrder(Cart order) {
        this.order = order;
    }

}
