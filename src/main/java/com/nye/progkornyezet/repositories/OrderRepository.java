package com.nye.progkornyezet.repositories;

import com.nye.progkornyezet.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}