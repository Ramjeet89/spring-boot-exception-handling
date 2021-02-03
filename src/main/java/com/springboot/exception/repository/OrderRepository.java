package com.springboot.exception.repository;

import com.springboot.exception.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByName(String productName);
}
