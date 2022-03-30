package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Medicine;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.MedicineRepository;
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
class MedicineServiceImplTest {

    @InjectMocks
    private MedicineServiceImpl medicineService;

    @Mock
    private MedicineRepository medicineRepository;

    private Medicine medicine;

    private Medicine medicineNew;

    private final long EXISTING_ID = 1L;
    private final long NOT_EXISTING_ID = 500L;

    private final String EXISTING_NAME = "Existing Name";
    private final String NEW_NAME = "New Name";
    private final String EXISTING_DESC = "Existing description";

    @BeforeEach
    void setUp() {

        medicine = Medicine.builder()
                .id(EXISTING_ID)
                .name(EXISTING_NAME)
                .description(EXISTING_DESC)
                .build();

        medicineNew = Medicine.builder()
                .id(EXISTING_ID)
                .name(NEW_NAME)
                .description(EXISTING_DESC)
                .build();

    }

    @Test
    void getMedicineByCorrectIdShouldReturnMedicine() {
        when(medicineRepository.findById(EXISTING_ID)).thenReturn(Optional.of(medicine));
        Medicine actual = medicineService.getById(EXISTING_ID);
        assertEquals(actual, medicine);
    }

    @Test
    void getMedicineByWrongIdShouldThrowNotFoundException() {
        when(medicineRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            medicineService.getById(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createMedicineShouldReturnMedicine() {
        when(medicineRepository.save(medicine)).thenReturn(medicine);
        Medicine actual = medicineService.save(medicine);
        assertEquals(actual.getName(), medicine.getName());
        verify(medicineRepository).save(medicine);
    }

    @Test
    void updateMedicineShouldReturnMedicine() {
        when(medicineRepository.findById(EXISTING_ID)).thenReturn(Optional.of(medicine));
        when(medicineRepository.save(medicine)).thenReturn(medicine);
        Medicine actual = medicineService.update(EXISTING_ID, medicineNew);
        assertEquals(actual, medicine);
    }

    @Test
    void deleteMedicineByCorrectIdShouldReturnMedicine() {
        when(medicineRepository.findById(EXISTING_ID)).thenReturn((Optional.of((medicine))));
        medicineService.delete(EXISTING_ID);
        verify(medicineRepository).delete(medicine);
    }

    @Test
    void deleteMedicineByNotExistingIdShouldThrowNotFoundException() {
        when(medicineRepository.findById(NOT_EXISTING_ID)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            medicineService.delete(NOT_EXISTING_ID);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void getListOfMedicineShouldReturnList() {
        when(medicineRepository.findAll()).thenReturn(Arrays.asList(medicine));
        List<Medicine> actual = medicineService.getAll();
        assertEquals(actual, Arrays.asList(medicine));
        verify(medicineRepository).findAll();
    }
}
