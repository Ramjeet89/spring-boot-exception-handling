package com.springboot.exception.service;

import com.springboot.exception.exception.OrderServiceException;
import com.springboot.exception.model.Order;
import com.springboot.exception.repository.OrderRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @PostConstruct
    public void addOrder2DB() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(876, "Mobile", "Electronics", 8000));
        orders.add(new Order(806, "Bike", "Veichlie", 90000));
        repository.saveAll(orders);
    }

    public double getPrice(String productName) throws OrderServiceException {
        Order order = null;
        double amount = 0;
        try {
            order = repository.findByName(productName);
            amount = order.getAmount();
        } catch (Exception e) {
        throw  new OrderServiceException("Order not found with product: "+productName);
        }
        return order.getAmount();
    }
}
