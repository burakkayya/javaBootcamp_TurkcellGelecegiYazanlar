package org.example;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager(new VakifbankPosServiceAdapter());

        orderManager.makePayment();
    }
}