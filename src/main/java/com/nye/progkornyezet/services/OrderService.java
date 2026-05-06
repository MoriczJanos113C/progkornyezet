package com.nye.progkornyezet.services;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.repositories.OrderRepository;
import com.nye.progkornyezet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing orders.
 */
@Service
@RequiredArgsConstructor
public final class OrderService {

    /**
     * Repository for orders.
     */
    private final OrderRepository orderRepository;

    /**
     * Repository for users.
     */
    private final UserRepository userRepository;

    /**
     * Returns all orders.
     * @return list of orders
     */
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /**
     * Returns an order by ID.
     * @param id order ID
     * @return found order
     */
    public Order getById(final Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    /**
     * Saves an order and attaches the managed user entity.
     * @param order order to save
     * @return saved order
     */
    public Order save(final Order order) {
        Long userId = order.getUser().getId();

        User user = userRepository.findById(userId).orElseThrow();
        order.setUser(user);

        return orderRepository.save(order);
    }

    /**
     * Deletes an order by ID.
     * @param id order ID
     */
    public void delete(final Long id) {
        orderRepository.deleteById(id);
    }
}
