package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.ArmorVest;
import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.entity.Order;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ArmorVestRepository;
import com.ua.volunteering.volunteering.repository.ClothesRepository;
import com.ua.volunteering.volunteering.repository.MedicineRepository;
import com.ua.volunteering.volunteering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ClothesRepository clothesRepository;

    private final ArmorVestRepository armorVestRepository;

    private final MedicineRepository medicineRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ClothesRepository clothesRepository, ArmorVestRepository armorVestRepository, MedicineRepository medicineRepository) {
        this.orderRepository = orderRepository;
        this.clothesRepository = clothesRepository;
        this.armorVestRepository = armorVestRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Order save(Order order, Set<Long> clothesId, Set<Long> armorVestId, Set<Long> medicineId) {
        List<Clothes> clothes = clothesRepository.findAllById(clothesId);
        List<ArmorVest> armorVestList = armorVestRepository.findAllById(armorVestId);
        List<Medicine> medicineList = medicineRepository.findAllById(medicineId);
        order.setClothes(clothes);
        order.setArmorVestList(armorVestList);
        order.setMedicineList(medicineList);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Set<Long> clothesId, Set<Long> armorVestId, Set<Long> medicineId) {
        Order updatedOrder = getById(id);
        List<Clothes> clothes = clothesRepository.findAllById(clothesId);
        List<ArmorVest> armorVestList = armorVestRepository.findAllById(armorVestId);
        List<Medicine> medicineList = medicineRepository.findAllById(medicineId);
        updatedOrder.setClothes(clothes);
        updatedOrder.setMedicineList(medicineList);
        updatedOrder.setArmorVestList(armorVestList);
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
