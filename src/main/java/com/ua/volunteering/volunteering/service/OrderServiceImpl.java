package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Order;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order updatedOrder = getById(id);
        updatedOrder.setId(order.getId());
//        updatedOrder.setClothes(order.getClothes());
//        updatedOrder.setMedicineList(order.getMedicineList());
//        updatedOrder.setArmorVestList(order.getArmorVestList());
        return orderRepository.save(updatedOrder);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
