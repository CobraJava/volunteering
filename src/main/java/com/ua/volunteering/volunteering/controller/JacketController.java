package com.ua.volunteering.volunteering.controller;


import com.ua.volunteering.volunteering.entity.Jacket;
import com.ua.volunteering.volunteering.service.JacketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jacket")
public class JacketController {

    private final JacketServiceImpl jacketService;

    @Autowired
    public JacketController(JacketServiceImpl jacketService) {
        this.jacketService = jacketService;
    }

    @PostMapping
    public Jacket create(@RequestBody Jacket jacket) {
        return jacketService.save(jacket);
    }

    @GetMapping
    public List<Jacket> findAll() {
        return jacketService.getAll();
    }

    @PutMapping("/{id}")
    public Jacket update(@PathVariable Long id, @RequestBody Jacket jacket) {
        return jacketService.update(id, jacket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jacketService.delete(id);
    }

    @GetMapping("/{id}")
    public Jacket findById(@PathVariable Long id) {
        return jacketService.getById(id);
    }
}
