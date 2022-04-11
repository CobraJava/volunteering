package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Paracetamol;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ParacetamolRepository;
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
class ParacetamolServiceImplTest {

    @InjectMocks
    private ParacetamolServiceImpl paracetamolService;

    @Mock
    private ParacetamolRepository paracetamolRepository;

    private Paracetamol paracetamol;

    private Paracetamol paracetamolNew;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final String EXISTING_NAME = "Existing Name";
    private final String NEW_NAME = "New Name";
    private final String EXISTING_PRESC = "Existing prescription";
    private final String EXISTING_DESC = "Existing description";
    private final long EXISTING_ORDER_ID = 1L;

    @BeforeEach
    void setUp() {

        paracetamol = Paracetamol.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .prescription(EXISTING_PRESC)
                .description(EXISTING_DESC)
                .orderId(EXISTING_ORDER_ID)
                .build();

        paracetamolNew = Paracetamol.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .prescription(EXISTING_PRESC)
                .description(EXISTING_DESC)
                .orderId(EXISTING_ORDER_ID)
                .build();

    }

    @Test
    void getParacetamolByCorrectIdShouldReturnParacetamol() {
        when(paracetamolRepository.findById(EXISTING_ID)).thenReturn(Optional.of(paracetamol));
        Paracetamol actual = paracetamolService.getById(EXISTING_ID);
        assertEquals(actual, paracetamol);
    }

    @Test
    void getParacetamolByWrongIdShouldThrowNotFoundException() {
        when(paracetamolRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            paracetamolService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createParacetamolShouldReturnParacetamol() {
        when(paracetamolRepository.save(paracetamol)).thenReturn(paracetamol);
        Paracetamol actual = paracetamolService.save(paracetamol);
        assertEquals(actual.getName(), paracetamol.getName());
        verify(paracetamolRepository).save(paracetamol);
    }

    @Test
    void updateParacetamolShouldReturnParacetamol() {
        when(paracetamolRepository.findById(EXISTING_ID)).thenReturn(Optional.of(paracetamol));
        when(paracetamolRepository.save(paracetamol)).thenReturn(paracetamol);
        Paracetamol actual = paracetamolService.update(EXISTING_ID, paracetamolNew);
        assertEquals(actual, paracetamol);
    }

    @Test
    void deleteParacetamolByCorrectIdShouldReturnVoid() {
        when(paracetamolRepository.findById(EXISTING_ID)).thenReturn((Optional.of((paracetamol))));
        paracetamolService.delete(EXISTING_ID);
        verify(paracetamolRepository).delete(paracetamol);
    }

    @Test
    void deleteParacetamolByNotExistingIdShouldThrowNotFoundException() {
        when(paracetamolRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            paracetamolService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfParacetamolShouldReturnList() {
        when(paracetamolRepository.findAll()).thenReturn(Arrays.asList(paracetamol));
        List<Paracetamol> actual = paracetamolService.getAll();
        assertEquals(actual, Arrays.asList(paracetamol));
        verify(paracetamolRepository).findAll();
    }
}
