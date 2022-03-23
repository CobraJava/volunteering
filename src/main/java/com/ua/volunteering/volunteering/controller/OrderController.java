package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.entity.Order;
import com.ua.volunteering.volunteering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody Order order,
                        @RequestParam(required = false) Set<Long> clothesId,
                        @RequestParam(required = false) Set<Long> armorVestId,
                        @RequestParam(required = false) Set<Long> medicineId) {
        return orderService.save(order,clothesId, armorVestId, medicineId);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.getAll();
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id,
                        @RequestParam(required = false) Set<Long> clothesId,
                        @RequestParam(required = false) Set<Long> armorVestId,
                        @RequestParam(required = false) Set<Long> medicineId) {
        return orderService.update(id, clothesId, armorVestId, medicineId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.getById(id);
    }

}
