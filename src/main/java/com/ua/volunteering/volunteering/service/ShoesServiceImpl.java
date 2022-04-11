package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Shoes;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoesServiceImpl implements BaseService<Shoes> {

    private final ShoesRepository shoesRepository;

    @Autowired
    public ShoesServiceImpl(ShoesRepository shoesRepository) {
        this.shoesRepository = shoesRepository;
    }

    @Override
    public Shoes getById(Long id) {
        return shoesRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Shoes save(Shoes shoes) {
        shoes.setName(shoes.getName());
        shoes.setSizeUK(shoes.getSizeUK());
        shoes.setOrderId(shoes.getOrderId());
        return shoesRepository.save(shoes);
    }

    @Override
    public Shoes update(Long id, Shoes shoes) {
        Shoes updatedShoes = getById(id);
        updatedShoes.setName(shoes.getName());
        updatedShoes.setSizeUK(shoes.getSizeUK());
        updatedShoes.setOrderId(shoes.getOrderId());
        return shoesRepository.save(updatedShoes);
    }

    @Override
    public void delete(Long id) {
        shoesRepository.delete(getById(id));

    }

//    @Override
    public List<Shoes> getAll() {
        return shoesRepository.findAll();
    }
}
