package com.nye.progkornyezet.controllers;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}