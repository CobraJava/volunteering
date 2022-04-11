package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.*;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.*;
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
    private JacketRepository jacketRepository;

    @Mock
    private ShoesRepository shoesRepository;

    @Mock
    private FarmacetronRepository farmacetronRepository;

    @Mock
    private ParacetamolRepository paracetamolRepository;

    @Mock
    private ArmorVestRepository armorVestRepository;

    private Order order;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final Set<Long> JACKET_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final Set<Long> NEW_JACKET_ID = Stream.of(1L, 3L).collect(Collectors.toSet());
    private final List<Jacket> JACKET_LIST = Lists.list(Jacket.builder().id(1L).name("Jacket").size(Size.L).orderId(1L).build(), Jacket.builder().id(2L).name("Jacket Vintage").size(Size.L).orderId(1L).build());

    private final Set<Long> SHOES_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final List<Shoes> SHOES_LIST = Lists.list(Shoes.builder().id(1L).name("New balance").sizeUK(39).orderId(1L).build(), Shoes.builder().id(2L).name("Adidas").sizeUK(44).orderId(1L).build());

    private final Set<Long> PARACETAMOL_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final List<Paracetamol> PARACETAMOL_LIST = Lists.list(Paracetamol.builder().id(1L).name("Paracetamol").prescription("any usage").description("any usage").orderId(1L).build(), Paracetamol.builder().id(2L).name("Paracetamol2x").description("any usage").orderId(1L).build());

    private final Set<Long> FARMACETRON_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final List<Farmacetron> FARMACETRON_LIST = Lists.list(Farmacetron.builder().id(1L).name("Farmacetron").prescription("any usage").dosage("any dosage").orderId(1L).build(), Farmacetron.builder().id(2L).name("Farmacetron2x").dosage("any dosage").orderId(1L).build());

    private final Set<Long> ARMORVEST_ID = Stream.of(1L, 2L).collect(Collectors.toSet());
    private final List<ArmorVest> ARMORVEST_LIST = Lists.list(ArmorVest.builder().id(1L).name("Model55").protection(3).orderId(1L).build(), ArmorVest.builder().id(2L).name("Model56").protection(4).orderId(1L).build());

    @BeforeEach
    void setUp() {


        order = Order.builder()
                .id(EXISTING_ID)
                .jackets(JACKET_LIST)
                .shoes(SHOES_LIST)
                .paracetamolList(PARACETAMOL_LIST)
                .farmacetronList(FARMACETRON_LIST)
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
        when(jacketRepository.findAllById(JACKET_ID)).thenReturn(JACKET_LIST);
        when(shoesRepository.findAllById(SHOES_ID)).thenReturn(SHOES_LIST);
        when(paracetamolRepository.findAllById(PARACETAMOL_ID)).thenReturn(PARACETAMOL_LIST);
        when(farmacetronRepository.findAllById(FARMACETRON_ID)).thenReturn(FARMACETRON_LIST);
        when(armorVestRepository.findAllById(ARMORVEST_ID)).thenReturn(ARMORVEST_LIST);
        Order actual = orderService.save(JACKET_ID, SHOES_ID, PARACETAMOL_ID, FARMACETRON_ID, ARMORVEST_ID);
        assertEquals(actual, order);

    }

    @Test
    void updateOrderShouldReturnOrder() {
        when(orderRepository.findById(EXISTING_ID)).thenReturn(Optional.of(order));
        when(orderRepository.save(order)).thenReturn(order);
        when(jacketRepository.findAllById(anyIterable())).thenReturn(JACKET_LIST);
        when(shoesRepository.findAllById(anyIterable())).thenReturn(SHOES_LIST);
        when(paracetamolRepository.findAllById(anyIterable())).thenReturn(PARACETAMOL_LIST);
        when(farmacetronRepository.findAllById(anyIterable())).thenReturn(FARMACETRON_LIST);
        when(armorVestRepository.findAllById(anyIterable())).thenReturn(ARMORVEST_LIST);
        Order actual = orderService.update(EXISTING_ID, NEW_JACKET_ID, SHOES_ID, PARACETAMOL_ID, FARMACETRON_ID, ARMORVEST_ID);
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
