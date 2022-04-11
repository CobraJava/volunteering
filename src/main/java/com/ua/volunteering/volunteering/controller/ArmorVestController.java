package com.ua.volunteering.volunteering.controller;


import com.ua.volunteering.volunteering.entity.ArmorVest;
import com.ua.volunteering.volunteering.service.ArmorVestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armor_vest")
public class ArmorVestController {

    private final ArmorVestServiceImpl armorVestService;

    @Autowired
    public ArmorVestController(ArmorVestServiceImpl armorVestService) {
        this.armorVestService = armorVestService;
    }

    @PostMapping
    public ArmorVest create(@RequestBody ArmorVest armorVest) {
        return armorVestService.save(armorVest);
    }

    @GetMapping
    public List<ArmorVest> findAll() {
        return armorVestService.getAll();
    }

    @PutMapping("/{id}")
    public ArmorVest update(@PathVariable Long id, @RequestBody ArmorVest armorVest) {
        return armorVestService.update(id, armorVest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        armorVestService.delete(id);
    }

    @GetMapping("/{id}")
    public ArmorVest findById(@PathVariable Long id) {
        return armorVestService.getById(id);
    }

}
