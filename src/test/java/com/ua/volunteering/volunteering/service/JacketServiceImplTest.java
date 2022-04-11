package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Jacket;
import com.ua.volunteering.volunteering.entity.Size;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.JacketRepository;
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
class JacketServiceImplTest {

    @InjectMocks
    private JacketServiceImpl jacketService;

    @Mock
    private JacketRepository jacketRepository;

    private Jacket jacket;


    private Jacket jacketNew;

    private long EXISTING_ID = 1L;
    private long NOT_EXISTING_ID = 500L;

    private String EXISTING_NAME = "Existing Name";
    private String NEW_NAME = "NEW Name";
    private final long EXISTING_ORDER_ID = 1L;

    @BeforeEach
    void setUp() {

        jacket = Jacket.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .size(Size.L)
                .orderId(EXISTING_ORDER_ID)
                .build();


        jacketNew = Jacket.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .size(Size.S)
                .orderId(EXISTING_ORDER_ID)
                .build();

    }

    @Test
    void getJacketByCorrectIdShouldReturnJacket() {
        when(jacketRepository.findById(EXISTING_ID)).thenReturn(Optional.of(jacket));
        Jacket actual = jacketService.getById(EXISTING_ID);
        assertEquals(actual, jacket);
    }

    @Test
    void getJacketByWrongIdShouldThrowNotFoundException() {
        when(jacketRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            jacketService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createJacketShouldReturnJacket() {
        when(jacketRepository.save(jacket)).thenReturn(jacket);
        Jacket actual = jacketService.save(jacket);
        assertEquals(actual.getName(), jacket.getName());
        verify(jacketRepository).save(jacket);
    }

    @Test
    void updateJacketShouldReturnJacket() {
        when(jacketRepository.findById(EXISTING_ID)).thenReturn(Optional.of(jacket));
        when(jacketRepository.save(jacket)).thenReturn(jacket);
        Jacket actual = jacketService.update(EXISTING_ID, jacketNew);
        assertEquals(actual, jacket);
    }

    @Test
    void deleteJacketByCorrectIdShouldReturnVoid() {
        when(jacketRepository.findById(EXISTING_ID)).thenReturn((Optional.of((jacket))));
        jacketService.delete(EXISTING_ID);
        verify(jacketRepository).delete(jacket);
    }

    @Test
    void deleteJacketByNotExistingIdShouldThrowNotFoundException() {
        when(jacketRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            jacketService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfJacketShouldReturnList() {
        when(jacketRepository.findAll()).thenReturn(Arrays.asList(jacket));
        List<Jacket> actual = jacketService.getAll();
        assertEquals(actual, Arrays.asList(jacket));
        verify(jacketRepository).findAll();
    }
}
