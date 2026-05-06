package com.nye.progkornyezet.services;


import com.nye.progkornyezet.entities.User;
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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetAll() {
        User user1 = new User();
        User user2 = new User();

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        List<User> result = userService.getAll();

        assertEquals(2, result.size());
        verify(userRepository).findAll();
    }

    @Test
    void testGetById_found() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getById(1L);

        assertEquals(1L, result.getId());
        verify(userRepository).findById(1L);
    }

    @Test
    void testGetById_notFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getById(1L));

        verify(userRepository).findById(1L);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setId(1L);

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        assertEquals(user, result);
        verify(userRepository).save(user);
    }

    @Test
    void testDelete() {
        Long id = 1L;

        userService.delete(id);

        verify(userRepository).deleteById(id);
    }
}