package com.checker.ticket.controller.usecase;

import com.checker.ticket.controller.protocols.Controller;
import com.checker.ticket.controller.protocols.Request;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
class TrocaController implements Controller {

    @Override
    @PostMapping("/troca")
    public void handle(@RequestBody Request request) {
        System.out.println(request);
    }
}