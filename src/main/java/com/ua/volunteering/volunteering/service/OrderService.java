package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {

    Order getById(Long id);

    Order save(Order order, Set<Long> clothesId, Set<Long> armorVestId, Set<Long> medicineId);

    Order update(Long id, Set<Long> clothesId, Set<Long> armorVestId, Set<Long> medicineId);

    void delete(Long id);

    List<Order> getAll();
}
