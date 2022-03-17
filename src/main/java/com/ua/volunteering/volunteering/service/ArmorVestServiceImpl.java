package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.ArmorVest;
import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ArmorVestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorVestServiceImpl implements ArmorVestService {

    private final ArmorVestRepository armorVestRepository;

    @Autowired
    public ArmorVestServiceImpl(ArmorVestRepository armorVestRepository) {
        this.armorVestRepository = armorVestRepository;
    }

    @Override
    public ArmorVest getById(Long id) {
        return armorVestRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public ArmorVest save(ArmorVest armorVest) {
        return armorVestRepository.save(armorVest);
    }

    @Override
    public ArmorVest update(Long id, ArmorVest armorVest) {
        ArmorVest updatedArmorVest = getById(id);
        updatedArmorVest.setName(armorVest.getName());
        updatedArmorVest.setProtection(armorVest.getProtection());
        return armorVestRepository.save(updatedArmorVest);
    }

    @Override
    public void delete(Long id) {
        armorVestRepository.delete(getById(id));
    }

    @Override
    public List<ArmorVest> getAll() {
        return armorVestRepository.findAll();
    }
}
