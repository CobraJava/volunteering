package com.ua.volunteering.volunteering.service;

import com.ua.volunteering.volunteering.entity.Item;
import com.ua.volunteering.volunteering.exception.NotFoundException;
import com.ua.volunteering.volunteering.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Long id, Item item) {
        Item updateItem = getById(id);
        updateItem.setName(item.getName());
        updateItem.setAvailable(item.getAvailable());
        return itemRepository.save(updateItem);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(getById(id));
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
