package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Item;

import java.util.List;

public interface ItemService {

    Item getById(Long id);

    Item save(Item item);

    Item update(Long id, Item item);

    void delete(Long id);

    List<Item> getAll();

}
