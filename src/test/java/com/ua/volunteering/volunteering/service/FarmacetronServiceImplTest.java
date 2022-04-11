package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Farmacetron;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.FarmacetronRepository;
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
class FarmacetronServiceImplTest {

    @InjectMocks
    private FarmacetronServiceImpl farmacetronService;

    @Mock
    private FarmacetronRepository farmacetronRepository;

    private Farmacetron farmacetron;

    private Farmacetron farmacetronNew;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final String EXISTING_NAME = "Existing Name";
    private final String NEW_NAME = "New Name";
    private final String EXISTING_PRESC = "Existing prescription";
    private final String EXISTING_DOSAGE = "Existing DOSAGE";
    private final long EXISTING_ORDER_ID = 1L;


    @BeforeEach
    void setUp() {

        farmacetron = Farmacetron.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .prescription(EXISTING_PRESC)
                .dosage(EXISTING_DOSAGE)
                .orderId(EXISTING_ORDER_ID)
                .build();

        farmacetronNew = Farmacetron.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .prescription(EXISTING_PRESC)
                .dosage(EXISTING_DOSAGE)
                .orderId(EXISTING_ORDER_ID)
                .build();

    }

    @Test
    void getFarmacetronByCorrectIdShouldReturnFarmacetron() {
        when(farmacetronRepository.findById(EXISTING_ID)).thenReturn(Optional.of(farmacetron));
        Farmacetron actual = farmacetronService.getById(EXISTING_ID);
        assertEquals(actual, farmacetron);
    }

    @Test
    void getFarmacetronByWrongIdShouldThrowNotFoundException() {
        when(farmacetronRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            farmacetronService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createFarmacetronShouldReturnFarmacetron() {
        when(farmacetronRepository.save(farmacetron)).thenReturn(farmacetron);
        Farmacetron actual = farmacetronService.save(farmacetron);
        assertEquals(actual.getName(), farmacetron.getName());
        verify(farmacetronRepository).save(farmacetron);
    }

    @Test
    void updateFarmacetronShouldReturnFarmacetron() {
        when(farmacetronRepository.findById(EXISTING_ID)).thenReturn(Optional.of(farmacetron));
        when(farmacetronRepository.save(farmacetron)).thenReturn(farmacetron);
        Farmacetron actual = farmacetronService.update(EXISTING_ID, farmacetronNew);
        assertEquals(actual, farmacetron);
    }

    @Test
    void deleteFarmacetronByCorrectIdShouldReturnVoid() {
        when(farmacetronRepository.findById(EXISTING_ID)).thenReturn((Optional.of((farmacetron))));
        farmacetronService.delete(EXISTING_ID);
        verify(farmacetronRepository).delete(farmacetron);
    }

    @Test
    void deleteFarmacetronByNotExistingIdShouldThrowNotFoundException() {
        when(farmacetronRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            farmacetronService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfFarmacetronShouldReturnList() {
        when(farmacetronRepository.findAll()).thenReturn(Arrays.asList(farmacetron));
        List<Farmacetron> actual = farmacetronService.getAll();
        assertEquals(actual, Arrays.asList(farmacetron));
        verify(farmacetronRepository).findAll();
    }
}
