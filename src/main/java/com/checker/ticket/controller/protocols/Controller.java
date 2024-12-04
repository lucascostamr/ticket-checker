package com.checker.ticket.controller.protocols;

import org.springframework.http.ResponseEntity;

public interface Controller {
    public ResponseEntity<Object> handle(Request request);
}
