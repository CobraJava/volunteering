package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Farmacetron;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.FarmacetronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmacetronServiceImpl implements BaseService<Farmacetron> {

    private final FarmacetronRepository farmacetronRepository;

    @Autowired
    public FarmacetronServiceImpl(FarmacetronRepository farmacetronRepository) {
        this.farmacetronRepository = farmacetronRepository;
    }

    @Override
    public Farmacetron getById(Long id) {
        return farmacetronRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

    }

    @Override
    public Farmacetron save(Farmacetron farmacetron) {
        farmacetron.setName(farmacetron.getName());
        farmacetron.setPrescription(farmacetron.getPrescription());
        farmacetron.setDosage(farmacetron.getDosage());
        farmacetron.setOrderId(farmacetron.getOrderId());
        return farmacetronRepository.save(farmacetron);
    }

    @Override
    public Farmacetron update(Long id, Farmacetron farmacetron) {
        Farmacetron updatedFarmacetron = getById(id);
        updatedFarmacetron.setName(farmacetron.getName());
        updatedFarmacetron.setPrescription(farmacetron.getPrescription());
        updatedFarmacetron.setDosage(farmacetron.getDosage());
        updatedFarmacetron.setOrderId(farmacetron.getOrderId());
        return farmacetronRepository.save(updatedFarmacetron);
    }

    @Override
    public void delete(Long id) {
        farmacetronRepository.delete(getById(id));
    }

    @Override
    public List<Farmacetron> getAll() {
        return farmacetronRepository.findAll();
    }
}
