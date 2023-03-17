package org.example;

public class Sale {
    private int id;
    private Cart cart;

    public Sale(int id, Cart cart) {
        this.id = id;
        this.cart = cart;
    }

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
