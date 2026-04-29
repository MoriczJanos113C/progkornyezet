package com.nye.progkornyezet.services;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.repositories.OrderRepository;
import com.nye.progkornyezet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        Long userId = order.getUser().getId();

        User user = userRepository.findById(userId).orElseThrow();
        order.setUser(user);

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}