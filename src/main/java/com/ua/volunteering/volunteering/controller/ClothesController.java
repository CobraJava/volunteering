package com.ua.volunteering.volunteering.controller;


import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    @Autowired
    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public Clothes create(@RequestBody Clothes clothes) {
        return clothesService.save(clothes);
    }

    @GetMapping
    public List<Clothes> findAll() {
        return clothesService.getAll();
    }

    @PutMapping("/{id}")
    public Clothes update(@PathVariable Long id, @RequestBody Clothes clothes) {
        return clothesService.update(id, clothes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clothesService.delete(id);
    }

    @GetMapping("/{id}")
    public Clothes findById(@PathVariable Long id) {
        return clothesService.getById(id);
    }
}
