package com.checker.ticket.controller;

import org.springframework.http.ResponseEntity;

import com.checker.ticket.controller.protocols.Controller;
import com.checker.ticket.controller.protocols.Request;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.checker.ticket.services.protocols.CheckAmountOrders;

@RestController
public class OrderController implements Controller{

    @Autowired
    private CheckAmountOrders checkAmountOrders;

    @Override
    @PostMapping("/order")

    public ResponseEntity<Object> handle(@RequestBody Request request) {
        try {
            int clientId = (int) request.clientId();
            int response = checkAmountOrders.getAmountOrders(clientId);
            return ResponseEntity.ok(response);
        } catch (ClassCastException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid Params");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Server Error");
        }
    }
}
