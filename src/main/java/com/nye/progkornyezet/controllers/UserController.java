package com.nye.progkornyezet.controllers;

import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for User operations.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    /**
     * User service instance.
     */
    private final UserService userService;

    /**
     * Returns all users.
     * @return list of users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Returns a user by ID.
     * @param id user ID
     * @return found user
     */
    @GetMapping("/oneUser/{id}")
    public User getById(final @PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * Creates a new user.
     * @param user user to create
     * @return created user
     */
    @PostMapping("/create")
    public User create(final @RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Updates a user.
     * @param id user ID
     * @param user updated user data
     * @return updated user
     */
    @PutMapping("/update/{id}")
    public User update(
            final @PathVariable Long id,
            final @RequestBody User user
    ) {
        user.setId(id);
        return userService.save(user);
    }

    /**
     * Deletes a user by ID.
     * @param id user ID
     */
    @DeleteMapping("/delete/{id}")
    public void delete(final @PathVariable Long id) {
        userService.delete(id);
    }
}
