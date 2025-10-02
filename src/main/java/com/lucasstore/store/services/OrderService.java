package com.lucasstore.store.services;

import com.lucasstore.store.models.Order;
import com.lucasstore.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
