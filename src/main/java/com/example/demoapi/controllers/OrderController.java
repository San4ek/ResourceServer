package com.example.demoapi.controllers;

import com.example.demoapi.models.TacoOrder;
import com.example.demoapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TacoOrder> findAll(Pageable pageable, JwtAuthenticationToken token) {
        return orderRepository.findAllByUser_Username(
                token.getTokenAttributes().get("sub").toString(),
                pageable);
    }
}
