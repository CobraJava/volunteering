package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine getById(Long id) {
        return medicineRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine update(Long id, Medicine medicine) {
        Medicine updatedMedicine = getById(id);
        updatedMedicine.setName(medicine.getName());
        updatedMedicine.setDescription(medicine.getDescription());
        return medicineRepository.save(updatedMedicine);
    }

    @Override
    public void delete(Long id) {
        medicineRepository.delete(getById(id));
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }
}
