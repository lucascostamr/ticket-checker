package com.checker.ticket.model;

public class Ticket {
    private final int AMOUNT_TO_EXCHANGE = 15;
    
    private int amountTickets = 0;
    
    public Ticket(int amountTickets) {
        this.amountTickets = amountTickets;
    }

    public boolean hasEnoughTickets() {
        if(this.amountTickets >= this.AMOUNT_TO_EXCHANGE) {
            return true;
        }
        return false;
    }
}
