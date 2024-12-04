package com.checker.ticket.model;

public class Order {
    private int amountOrders = 0;
    
    public Order(int amountOrders) {
        this.amountOrders = amountOrders;
    }

    public int getAmountOrders() {
        return this.amountOrders;
    }
}
