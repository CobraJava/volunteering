package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.entity.Paracetamol;
import com.ua.volunteering.volunteering.service.ParacetamolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paracetamol")
public class ParacetamolController {

    private final ParacetamolServiceImpl paracetamolService;

    @Autowired
    public ParacetamolController(ParacetamolServiceImpl paracetamolService) {
        this.paracetamolService = paracetamolService;
    }

    @PostMapping
    public Paracetamol create(@RequestBody Paracetamol paracetamol) {
        return paracetamolService.save(paracetamol);
    }

    @GetMapping
    public List<Paracetamol> findAll() {
        return paracetamolService.getAll();
    }

    @PutMapping("/{id}")
    public Paracetamol update(@PathVariable Long id, @RequestBody Paracetamol paracetamol) {
        return paracetamolService.update(id, paracetamol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paracetamolService.delete(id);
    }

    @GetMapping("/{id}")
    public Medicine findById(@PathVariable Long id) {
        return paracetamolService.getById(id);
    }

}
