package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Clothes;
import com.ua.volunteering.volunteering.entity.Size;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ClothesRepository;
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
class ClothesServiceImplTest {

    @InjectMocks
    private ClothesServiceImpl clothesService;

    @Mock
    private ClothesRepository clothesRepository;

    private Clothes clothes;

    private Clothes clothesNew;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final String EXISTING_NAME = "Existing Name";
    private final String NEW_NAME = "NEW Name";


    @BeforeEach
    void setUp() {

        clothes = Clothes.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .size(Size.L)
                .build();

        clothesNew = Clothes.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .size(Size.L)
                .build();

    }

    @Test
    void getClothesByCorrectIdShouldReturnClothes() {
        when(clothesRepository.findById(EXISTING_ID)).thenReturn(Optional.of(clothes));
        Clothes actual = clothesService.getById(EXISTING_ID);
        assertEquals(actual, clothes);
    }

    @Test
    void getClothesByWrongIdShouldThrowNotFoundException() {
        when(clothesRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            clothesService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createClothesShouldReturnClothes() {
        when(clothesRepository.save(clothes)).thenReturn(clothes);
        Clothes actual = clothesService.save(clothes);
        assertEquals(actual.getName(), clothes.getName());
        verify(clothesRepository).save(clothes);
    }

    @Test
    void updateClothesShouldReturnClothes() {
        when(clothesRepository.findById(EXISTING_ID)).thenReturn(Optional.of(clothes));
        when(clothesRepository.save(clothes)).thenReturn(clothes);
        Clothes actual = clothesService.update(EXISTING_ID, clothesNew);
        assertEquals(actual, clothes);
    }

    @Test
    void deleteClothesByCorrectIdShouldReturnClothes() {
        when(clothesRepository.findById(EXISTING_ID)).thenReturn((Optional.of((clothes))));
        clothesService.delete(EXISTING_ID);
        verify(clothesRepository).delete(clothes);
    }

    @Test
    void deleteClothesByNotExistingIdShouldThrowNotFoundException() {
        when(clothesRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            clothesService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfClothesShouldReturnList() {
        when(clothesRepository.findAll()).thenReturn(Arrays.asList(clothes));
        List<Clothes> actual = clothesService.getAll();
        assertEquals(actual, Arrays.asList(clothes));
        verify(clothesRepository).findAll();
    }
}
