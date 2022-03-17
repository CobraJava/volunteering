package com.ua.volunteering.volunteering.service;


import com.ua.volunteering.volunteering.dto.ClothesDto;
import com.ua.volunteering.volunteering.dto.ClothesDtoResponse;
import com.ua.volunteering.volunteering.entity.Clothes;

import java.util.List;

public interface ClothesService {

    Clothes getById(Long id);

    Clothes save(Clothes clothes);

    Clothes update(Long id, Clothes clothes);

    void delete(Long id);

    List<Clothes> getAll();

}
