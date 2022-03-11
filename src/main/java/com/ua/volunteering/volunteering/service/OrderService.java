package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Item;
import com.ua.volunteering.volunteering.entity.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long id);

    Order save(Order order);

    Order update(Long id, Order order);

    void delete(Long id);

    List<Order> getAll();
}
