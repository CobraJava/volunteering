package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Medicine;

import java.util.List;

public interface MedicineService {

    Medicine getById(Long id);

    Medicine save(Medicine medicine);

    Medicine update(Long id, Medicine medicine);

    void delete(Long id);

    List<Medicine> getAll();

}
