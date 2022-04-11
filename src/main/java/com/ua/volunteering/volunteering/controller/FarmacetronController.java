package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Farmacetron;
import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.service.FarmacetronServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacetron")
public class FarmacetronController {

    private final FarmacetronServiceImpl farmacetronService;

    @Autowired
    public FarmacetronController(FarmacetronServiceImpl farmacetronService) {
        this.farmacetronService = farmacetronService;
    }

    @PostMapping
    public Farmacetron create(@RequestBody Farmacetron farmacetron) {
        return farmacetronService.save(farmacetron);
    }

    @GetMapping
    public List<Farmacetron> findAll() {
        return farmacetronService.getAll();
    }

    @PutMapping("/{id}")
    public Farmacetron update(@PathVariable Long id, @RequestBody Farmacetron farmacetron) {
        return farmacetronService.update(id, farmacetron);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        farmacetronService.delete(id);
    }

    @GetMapping("/{id}")
    public Medicine findById(@PathVariable Long id) {
        return farmacetronService.getById(id);
    }


}
