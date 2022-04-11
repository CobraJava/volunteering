package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Shoes;
import com.ua.volunteering.volunteering.service.ShoesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesController {

    private final ShoesServiceImpl shoesService;

    @Autowired
    public ShoesController(ShoesServiceImpl shoesService) {
        this.shoesService = shoesService;
    }

    @PostMapping
    public Shoes create(@RequestBody Shoes shoes) {
        return shoesService.save(shoes);
    }

    @GetMapping
    public List<Shoes> findAll() {
        return shoesService.getAll();
    }

    @PutMapping("/{id}")
    public Shoes update(@PathVariable Long id, @RequestBody Shoes shoes) {
        return shoesService.update(id, shoes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shoesService.delete(id);
    }

    @GetMapping("/{id}")
    public Shoes findById(@PathVariable Long id) {
        return shoesService.getById(id);
    }
}
