package com.ua.volunteering.volunteering.controller;

import com.ua.volunteering.volunteering.entity.Item;
import com.ua.volunteering.volunteering.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item create(@RequestBody Item item) { return itemService.save(item);}

    @GetMapping
    public List<Item> findAll() {
        return itemService.getAll();
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) { return itemService.update(id, item); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { itemService.delete(id); }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) { return itemService.getById(id); }
}
