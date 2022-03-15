package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;

    @Autowired
    public ClothesServiceImpl(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Clothes getById(Long id) {
        return clothesRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Clothes save(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    @Override
    public Clothes update(Long id, Clothes clothes) {
        Clothes updatedClothes = getById(id);
        updatedClothes.setName(clothes.getName());
        updatedClothes.setSize(clothes.getSize());
        return clothesRepository.save(updatedClothes);
    }

    @Override
    public void delete(Long id) {
        clothesRepository.delete(getById(id));
    }

    @Override
    public List<Clothes> getAll() {
        return clothesRepository.findAll();
    }
}
