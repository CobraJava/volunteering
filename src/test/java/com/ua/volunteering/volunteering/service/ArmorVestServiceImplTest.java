package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.ArmorVest;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ArmorVestRepository;
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
class ArmorVestServiceImplTest {

    @InjectMocks
    private ArmorVestServiceImpl armorVestService;

    @Mock
    private ArmorVestRepository armorVestRepository;

    private ArmorVest armorVest;

    private ArmorVest armorVestNew;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final String EXISTING_NAME = "Existing Name";
    private final String NEW_NAME = "New Name";
    private final int EXISTING_PROTECTION = 1;
    private final long EXISTING_ORDER_ID = 1L;


    @BeforeEach
    void setUp() {

        armorVest = ArmorVest.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .protection(EXISTING_PROTECTION)
                .orderId(EXISTING_ORDER_ID)
                .build();
        armorVestNew = ArmorVest.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .protection(EXISTING_PROTECTION)
                .orderId(EXISTING_ORDER_ID)
                .build();
    }

    @Test
    void getArmorVestByCorrectIdShouldReturnArmorVest() {
        when(armorVestRepository.findById(EXISTING_ID)).thenReturn(Optional.of(armorVest));
        ArmorVest actual = armorVestService.getById(EXISTING_ID);
        assertEquals(actual, armorVest);
    }

    @Test
    void getArmorVestByWrongIdShouldThrowNotFoundException() {
        when(armorVestRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            armorVestService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createArmorVestShouldReturnArmorVest() {
        when(armorVestRepository.save(armorVest)).thenReturn(armorVest);
        ArmorVest actual = armorVestService.save(armorVest);
        assertEquals(actual.getName(), armorVest.getName());
        verify(armorVestRepository).save(armorVest);
    }

    @Test
    void updateArmorVestShouldReturnArmorVest() {
        when(armorVestRepository.findById(EXISTING_ID)).thenReturn(Optional.of(armorVest));
        when(armorVestRepository.save(armorVest)).thenReturn(armorVest);
        ArmorVest actual = armorVestService.update(EXISTING_ID, armorVestNew);
        assertEquals(actual, armorVest);
    }

    @Test
    void deleteArmorVestByCorrectIdShouldReturnVoid() {
        when(armorVestRepository.findById(EXISTING_ID)).thenReturn((Optional.of((armorVest))));
        armorVestService.delete(EXISTING_ID);
        verify(armorVestRepository).delete(armorVest);
    }

    @Test
    void deleteArmorVestByNotExistingIdShouldThrowNotFoundException() {
        when(armorVestRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            armorVestService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfArmorVestShouldReturnList() {
        when(armorVestRepository.findAll()).thenReturn(Arrays.asList(armorVest));
        List<ArmorVest> actual = armorVestService.getAll();
        assertEquals(actual, Arrays.asList(armorVest));
        verify(armorVestRepository).findAll();
    }
}
