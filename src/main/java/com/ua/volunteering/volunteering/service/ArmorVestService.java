package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.ArmorVest;
import com.ua.volunteering.volunteering.entity.Clothes;

import java.util.List;

public interface ArmorVestService {

    ArmorVest getById(Long id);

    ArmorVest save(ArmorVest armorVest);

    ArmorVest update(Long id, ArmorVest armorVest);

    void delete(Long id);

    List<ArmorVest> getAll();
}
