package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Jacket;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.JacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JacketServiceImpl implements BaseService<Jacket> {

    private final JacketRepository jacketRepository;


    @Autowired
    public JacketServiceImpl(JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }


    public Jacket getById(Long id) {
        return jacketRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Jacket save(Jacket jacket) {
        jacket.setName(jacket.getName());
        jacket.setSize(jacket.getSize());
        jacket.setOrderId(jacket.getOrderId());
        return jacketRepository.save(jacket);
    }

    @Override
    public Jacket update(Long id, Jacket jacket) {
        Jacket updatedJacket = getById(id);
        updatedJacket.setName(jacket.getName());
        updatedJacket.setSize(jacket.getSize());
        updatedJacket.setOrderId(jacket.getOrderId());
        return jacketRepository.save(updatedJacket);
    }

    @Override
    public void delete(Long id) {
        jacketRepository.delete(getById(id));
    }

    @Override
    public List<Jacket> getAll() {
        return jacketRepository.findAll();
    }

}
