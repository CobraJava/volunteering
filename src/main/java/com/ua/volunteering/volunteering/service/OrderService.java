package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {

    Order getById(Long id);

    Order save(Set<Long> armorVestId, Set<Long> jacketId, Set<Long> shoesId, Set<Long> paracetamolId, Set<Long> farmacetromId);

    Order update(Long id, Set<Long> armorVestId, Set<Long> jacketId, Set<Long> shoesId, Set<Long> paracetamolId, Set<Long> farmacetromId);

    void delete(Long id);

    List<Order> getAll();
}
