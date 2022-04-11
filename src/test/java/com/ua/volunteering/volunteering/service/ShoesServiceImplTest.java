package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Shoes;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ShoesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoesServiceImplTest {

    @InjectMocks
    private ShoesServiceImpl shoesService;

    @Mock
    private ShoesRepository shoesRepository;

    private Shoes shoes;


    private Shoes shoesNew;

    private long EXISTING_ID = 1L;
    private long NOT_EXISTING_ID = 500L;

    private String EXISTING_NAME = "Existing Name";
    private String NEW_NAME = "NEW Name";
    private int EXISTING_SIZE = 44;
    private final long EXISTING_ORDER_ID = 1L;


    @BeforeEach
    void setUp() {

        shoes = Shoes.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .sizeUK(EXISTING_SIZE)
                .orderId(EXISTING_ORDER_ID)
                .build();


        shoesNew = Shoes.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .sizeUK(EXISTING_SIZE)
                .orderId(EXISTING_ORDER_ID)
                .build();

    }

    @Test
    void getShoesByCorrectIdShouldReturnShoes() {
        when(shoesRepository.findById(EXISTING_ID)).thenReturn(Optional.of(shoes));
        Shoes actual = shoesService.getById(EXISTING_ID);
        assertEquals(actual, shoes);
    }

    @Test
    void getShoesByWrongIdShouldThrowNotFoundException() {
        when(shoesRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            shoesService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createShoesShouldReturnShoes() {
        when(shoesRepository.save(shoes)).thenReturn(shoes);
        Shoes actual = shoesService.save(shoes);
        assertEquals(actual.getName(), shoes.getName());
        verify(shoesRepository).save(shoes);
    }

    @Test
    void updateShoesShouldReturnShoes() {
        when(shoesRepository.findById(EXISTING_ID)).thenReturn(Optional.of(shoes));
        when(shoesRepository.save(shoes)).thenReturn(shoes);
        Shoes actual = shoesService.update(EXISTING_ID, shoesNew);
        assertEquals(actual, shoes);
    }

    @Test
    void deleteShoesByCorrectIdShouldReturnVoid() {
        when(shoesRepository.findById(EXISTING_ID)).thenReturn((Optional.of((shoes))));
        shoesService.delete(EXISTING_ID);
        verify(shoesRepository).delete(shoes);
    }

    @Test
    void deleteShoesByNotExistingIdShouldThrowNotFoundException() {
        when(shoesRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            shoesService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfShoesShouldReturnList() {
        when(shoesRepository.findAll()).thenReturn(Arrays.asList(shoes));
        List<Shoes> actual = shoesService.getAll();
        assertEquals(actual, Arrays.asList(shoes));
        verify(shoesRepository).findAll();
    }

}
