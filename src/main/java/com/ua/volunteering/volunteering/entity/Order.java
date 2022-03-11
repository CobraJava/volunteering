package com.ua.volunteering.volunteering.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "orders")
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }
}
