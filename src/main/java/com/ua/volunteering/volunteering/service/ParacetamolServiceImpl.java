package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Paracetamol;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ParacetamolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParacetamolServiceImpl implements BaseService<Paracetamol> {

    private final ParacetamolRepository paracetamolRepository;

    @Autowired
    public ParacetamolServiceImpl(ParacetamolRepository paracetamolRepository) {
        this.paracetamolRepository = paracetamolRepository;
    }

    @Override
    public Paracetamol getById(Long id) {
        return paracetamolRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Paracetamol save(Paracetamol paracetamol) {
        paracetamol.setName(paracetamol.getName());
        paracetamol.setPrescription(paracetamol.getPrescription());
        paracetamol.setDescription(paracetamol.getDescription());
        paracetamol.setOrderId(paracetamol.getOrderId());
        return paracetamolRepository.save(paracetamol);
    }

    @Override
    public Paracetamol update(Long id, Paracetamol paracetamol) {
        Paracetamol updatedParacetamol = getById(id);
        updatedParacetamol.setName(paracetamol.getName());
        updatedParacetamol.setDescription(paracetamol.getDescription());
        updatedParacetamol.setOrderId(paracetamol.getOrderId());
        return paracetamolRepository.save(updatedParacetamol);
    }

    @Override
    public void delete(Long id) {
        paracetamolRepository.delete(getById(id));
    }

    @Override
    public List<Paracetamol> getAll() {
        return paracetamolRepository.findAll();
    }
}
