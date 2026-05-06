package com.nye.progkornyezet.services;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.repositories.OrderRepository;
import com.nye.progkornyezet.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testGetAll() {
        Order order1 = new Order();
        Order order2 = new Order();

        when(orderRepository.findAll()).thenReturn(List.of(order1, order2));

        List<Order> result = orderService.getAll();

        assertEquals(2, result.size());
        verify(orderRepository).findAll();
    }

    @Test
    void testSave() {
        User user = new User();
        user.setId(1L);

        Order order = new Order();
        order.setUser(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.save(order);

        assertEquals(user, result.getUser());
        verify(userRepository).findById(1L);
        verify(orderRepository).save(order);
    }

    @Test
    void testSave_userNotFound() {
        // given
        User user = new User();
        user.setId(1L);

        Order order = new Order();
        order.setUser(user);

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // when + then
        assertThrows(RuntimeException.class, () -> orderService.save(order));

        verify(userRepository).findById(1L);
        verify(orderRepository, never()).save(any());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        orderService.delete(id);

        verify(orderRepository).deleteById(id);
    }
}