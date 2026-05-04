package com.nye.progkornyezet.controllers;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing orders.
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    /**
     * Order service instance.
     */
    private final OrderService orderService;

    /**
     * Returns all orders.
     * @return list of all orders
     */
    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * Creates a new order.
     * @param order order to create
     * @return created order
     */
    @PostMapping("/create")
    public Order create(final @RequestBody Order order) {
        return orderService.save(order);
    }

    /**
     * Deletes an order by ID.
     * @param id order ID
     */
    @DeleteMapping("/delete/{id}")
    public void delete(final @PathVariable Long id) {
        orderService.delete(id);
    }
}
