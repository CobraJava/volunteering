package com.ua.volunteering.volunteering.controller;

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
    public Order create(
            @RequestParam(required = false, defaultValue = "") Set<Long> armorVestId,
            @RequestParam(required = false, defaultValue = "") Set<Long> jacketId,
            @RequestParam(required = false, defaultValue = "") Set<Long> shoesId,
            @RequestParam(required = false, defaultValue = "") Set<Long> paracetamolId,
            @RequestParam(required = false, defaultValue = "") Set<Long> farmacetronId) {
        return orderService.save(armorVestId, jacketId, shoesId, paracetamolId, farmacetronId);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.getAll();
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id,
                        @RequestParam(required = false, defaultValue = "") Set<Long> armorVestId,
                        @RequestParam(required = false, defaultValue = "") Set<Long> jacketId,
                        @RequestParam(required = false, defaultValue = "") Set<Long> shoesId,
                        @RequestParam(required = false, defaultValue = "") Set<Long> paracetamolId,
                        @RequestParam(required = false, defaultValue = "") Set<Long> farmacetronId) {
        return orderService.update(id, armorVestId, jacketId, shoesId, paracetamolId, farmacetronId);
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
