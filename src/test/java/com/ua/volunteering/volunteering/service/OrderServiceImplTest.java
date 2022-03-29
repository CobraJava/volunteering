package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.*;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ArmorVestRepository;
import com.ua.volunteering.volunteering.repository.ClothesRepository;
import com.ua.volunteering.volunteering.repository.MedicineRepository;
import com.ua.volunteering.volunteering.repository.OrderRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ClothesRepository clothesRepository;

    @Mock
    private ArmorVestRepository armorVestRepository;

    @Mock
    private MedicineRepository medicineRepository;

    private Order order;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final Set<Long> CLOTHES_ID = Stream.of(1L, 2L, 3L).collect(Collectors.toSet());
    private final List<Clothes> CLOTHES_LIST = Lists.list(Clothes.builder().id(1L).name("Jeans").size(Size.L).build(), Clothes.builder().id(2L).name("T-shirt").size(Size.S).build());

    private final Set<Long> MEDICINE_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final List<Medicine> MEDICINE_LIST = Lists.list(Medicine.builder().id(1L).name("Paracetamol").description("any usage").build(), Medicine.builder().id(2L).name("Nurofen").description("any usage").build());

    private final Set<Long> ARMORVEST_ID = Stream.of(1L, 2L, 3L).collect(Collectors.toSet());
    private final List<ArmorVest> ARMORVEST_LIST = Lists.list(ArmorVest.builder().id(1L).name("Model55").protection(3).build(), ArmorVest.builder().id(2L).name("Model56").protection(4).build());

    @BeforeEach
    void setUp() {


        order = Order.builder()
                .id(EXISTING_ID)
                .clothes(CLOTHES_LIST)
                .medicineList(MEDICINE_LIST)
                .armorVestList(ARMORVEST_LIST)
                .build();

    }

    @Test
    void getOrderByCorrectIdShouldReturnOrder() {
        when(orderRepository.findById(EXISTING_ID)).thenReturn(Optional.of(order));
        Order actual = orderService.getById(EXISTING_ID);
        assertEquals(actual, order);
    }

    @Test
    void getOrderByWrongIdShouldThrowNotFoundException() {
        when(orderRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            orderService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createOrderShouldReturnOrder() {
        when(orderRepository.save(order)).thenReturn(order);
        when(clothesRepository.findAllById(anyIterable())).thenReturn(CLOTHES_LIST);
        when(medicineRepository.findAllById(anyIterable())).thenReturn(MEDICINE_LIST);
        when(armorVestRepository.findAllById(anyIterable())).thenReturn(ARMORVEST_LIST);
        Order actual = orderService.save(order, CLOTHES_ID, ARMORVEST_ID, MEDICINE_ID);
        assertEquals(actual, order);
        verify(orderRepository).save(order);
    }

    @Test
    void updateOrderShouldReturnOrder() {
        when(orderRepository.findById(EXISTING_ID)).thenReturn(Optional.of(order));
        when(orderRepository.save(order)).thenReturn(order);
        when(clothesRepository.findAllById(anyIterable())).thenReturn(CLOTHES_LIST);
        when(medicineRepository.findAllById(anyIterable())).thenReturn(MEDICINE_LIST);
        when(armorVestRepository.findAllById(anyIterable())).thenReturn(ARMORVEST_LIST);
        Order actual = orderService.update(EXISTING_ID, CLOTHES_ID, MEDICINE_ID, ARMORVEST_ID);
        assertEquals(actual, order);
        verify(orderRepository).save(order);
    }

    @Test
    void deleteOrderByCorrectIdShouldReturnOrder() {
        when(orderRepository.findById(EXISTING_ID)).thenReturn((Optional.of((order))));
        orderService.delete(EXISTING_ID);
        verify(orderRepository).delete(order);
    }

    @Test
    void deleteOrderByNotExistingIdShouldThrowNotFoundException() {
        when(orderRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            orderService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfOrdersShouldReturnList() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
        List<Order> actual = orderService.getAll();
        assertEquals(actual, Arrays.asList(order));
        verify(orderRepository).findAll();
    }
}
