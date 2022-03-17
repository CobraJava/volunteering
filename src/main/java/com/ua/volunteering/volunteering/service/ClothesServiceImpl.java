package com.ua.volunteering.volunteering.service;


import com.ua.volunteering.volunteering.dto.ClothesDto;
import com.ua.volunteering.volunteering.dto.ClothesDtoResponse;
import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ClothesRepository;
import com.ua.volunteering.volunteering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public ClothesServiceImpl(ClothesRepository clothesRepository, OrderRepository orderRepository) {
        this.clothesRepository = clothesRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Clothes getById(Long id) {
        return clothesRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Clothes save(Clothes clothes) {
        clothes.setName(clothes.getName());
        clothes.setSize(clothes.getSize());
        clothes.setOrder(clothes.getOrder());
        return clothesRepository.save(clothes);
    }

    @Override
    public Clothes update(Long id, Clothes clothes) {
        Clothes updatedClothes = getById(id);
        updatedClothes.setName(clothes.getName());
        updatedClothes.setSize(clothes.getSize());
        updatedClothes.setOrder(clothes.getOrder());
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
