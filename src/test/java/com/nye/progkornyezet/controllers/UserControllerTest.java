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

    @Test
    void testCreate() {
        User user = new User();
        user.setId(1L);

        when(userService.save(user)).thenReturn(user);

        User result = userController.create(user);

        assertEquals(1L, result.getId());
        verify(userService).save(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1L);

        when(userService.save(any(User.class))).thenReturn(user);

        User result = userController.update(1L, user);

        assertEquals(1L, result.getId());
        verify(userService).save(any(User.class));
    }

    @Test
    void testDelete() {
        doNothing().when(userService).delete(1L);

        userController.delete(1L);

        verify(userService).delete(1L);
    }
}