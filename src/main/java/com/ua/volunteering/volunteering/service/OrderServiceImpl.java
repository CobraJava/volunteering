package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.*;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final JacketRepository jacketRepository;

    private final ShoesRepository shoesRepository;

    private final ArmorVestRepository armorVestRepository;

    private final ParacetamolRepository paracetamolRepository;

    private final FarmacetronRepository farmacetronRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, JacketRepository jacketRepository, ShoesRepository shoesRepository, ArmorVestRepository armorVestRepository, ParacetamolRepository paracetamolRepository, FarmacetronRepository farmacetronRepository) {
        this.orderRepository = orderRepository;
        this.jacketRepository = jacketRepository;
        this.shoesRepository = shoesRepository;
        this.armorVestRepository = armorVestRepository;
        this.paracetamolRepository = paracetamolRepository;
        this.farmacetronRepository = farmacetronRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Order save(Set<Long> armorVestId, Set<Long> jacketId, Set<Long> shoesId, Set<Long> paracetamolId, Set<Long> farmacetromId) {
        Order order = new Order();
        List<ArmorVest> armorVestList = armorVestRepository.findAllById(armorVestId).stream().filter(armorVest -> armorVest.getOrderId()==null).collect(Collectors.toList());
        List<Jacket> jackets = jacketRepository.findAllById(jacketId).stream().filter(jacket -> jacket.getOrderId()==null).collect(Collectors.toList());
        List<Shoes> shoesList = shoesRepository.findAllById(shoesId).stream().filter(shoes -> shoes.getOrderId()==null).collect(Collectors.toList());
        List<Paracetamol> paracetamolList = paracetamolRepository.findAllById(paracetamolId).stream().filter(paracetamol -> paracetamol.getOrderId()==null).collect(Collectors.toList());
        List<Farmacetron> farmacetronList = farmacetronRepository.findAllById(farmacetromId).stream().filter(farmacetron -> farmacetron.getOrderId()==null).collect(Collectors.toList());
        order.setArmorVestList(armorVestList);
        order.setJackets(jackets);
        order.setShoes(shoesList);
        order.setParacetamolList(paracetamolList);
        order.setFarmacetronList(farmacetronList);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Set<Long> armorVestId, Set<Long> jacketId, Set<Long> shoesId, Set<Long> paracetamolId, Set<Long> farmacetromId) {
        Order updatedOrder = getById(id);
        List<ArmorVest> armorVestList = armorVestRepository.findAllById(armorVestId).stream().filter(armorVest -> armorVest.getOrderId()==null).collect(Collectors.toList());
        List<Jacket> jackets = jacketRepository.findAllById(jacketId).stream().filter(jacket -> jacket.getOrderId()==null).collect(Collectors.toList());
        List<Farmacetron> farmacetronList = farmacetronRepository.findAllById(farmacetromId).stream().filter(farmacetron -> farmacetron.getOrderId()==null).collect(Collectors.toList());
        List<Paracetamol> paracetamolList = paracetamolRepository.findAllById(paracetamolId).stream().filter(paracetamol -> paracetamol.getOrderId()==null).collect(Collectors.toList());
        List<Shoes> shoesList = shoesRepository.findAllById(shoesId).stream().filter(shoes -> shoes.getOrderId()==null).collect(Collectors.toList());
        updatedOrder.setArmorVestList(armorVestList);
        updatedOrder.setJackets(jackets);
        updatedOrder.setShoes(shoesList);
        updatedOrder.setParacetamolList(paracetamolList);
        updatedOrder.setFarmacetronList(farmacetronList);
        return orderRepository.save(updatedOrder);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }


}
