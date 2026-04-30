package com.nye.progkornyezet.services;

import com.nye.progkornyezet.entities.User;
import com.nye.progkornyezet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class UserService {

    /**
     * Repository for users.
     */
    private final UserRepository userRepository;

    /**
     * Returns all users.
     * @return list of users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Returns a user by ID.
     * @param id user ID
     * @return found user
     */
    public User getById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    /**
     * Saves a user.
     * @param user user to save
     * @return saved user
     */
    public User save(final User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user by ID.
     * @param id user ID
     */
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }
}
