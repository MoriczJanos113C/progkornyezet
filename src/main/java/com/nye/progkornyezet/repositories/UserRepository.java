package com.nye.progkornyezet.repositories;

import com.nye.progkornyezet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}