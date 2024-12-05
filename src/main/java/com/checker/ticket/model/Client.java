package com.checker.ticket.model;

public class Client {
    private int amountExchange = 0;

    public Client(int amountExchange) {
        this.amountExchange = amountExchange;
    }

    public int getAmountExchange() {
        return this.amountExchange;
    }
}
