package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping
    public Medicine create(@RequestBody Medicine medicine) {
        return medicineService.save(medicine);
    }

    @GetMapping
    public List<Medicine> findAll() {
        return medicineService.getAll();
    }

    @PutMapping("/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine medicine) {
        return medicineService.update(id, medicine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicineService.delete(id);
    }

    @GetMapping("/{id}")
    public Medicine findById(@PathVariable Long id) {
        return medicineService.getById(id);
    }

}
