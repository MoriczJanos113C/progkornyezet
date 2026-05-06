package com.nye.progkornyezet.controllers;

import com.nye.progkornyezet.entities.Order;
import com.nye.progkornyezet.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testGetAll() {
        Order o1 = new Order();
        Order o2 = new Order();

        when(orderService.getAll()).thenReturn(List.of(o1, o2));

        List<Order> result = orderController.getAll();

        assertEquals(2, result.size());
        verify(orderService).getAll();
    }

    @Test
    void testCreate() {
        Order order = new Order();

        when(orderService.save(order)).thenReturn(order);

        Order result = orderController.create(order);

        assertEquals(order, result);
        verify(orderService).save(order);
    }

    @Test
    void testDelete() {
        Long id = 1L;

        doNothing().when(orderService).delete(id);

        orderController.delete(id);

        verify(orderService).delete(id);
    }
}