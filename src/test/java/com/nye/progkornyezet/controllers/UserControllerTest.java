package com.nye.progkornyezet.controllers;

import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAll() {
        User u1 = new User();
        User u2 = new User();

        when(userService.getAll()).thenReturn(List.of(u1, u2));

        List<User> result = userController.getAll();

        assertEquals(2, result.size());
        verify(userService).getAll();
    }

    @Test
    void testGetById() {
        User user = new User();
        user.setId(1L);

        when(userService.getById(1L)).thenReturn(user);

        User result = userController.getById(1L);

        assertEquals(1L, result.getId());
        verify(userService).getById(1L);
    }
}