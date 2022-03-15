package com.ua.volunteering.volunteering.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "clothes")
public class Clothes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private String size;



//    @ManyToMany
//    @JoinTable(
//            name = "items_orders",
//            joinColumns = @JoinColumn(name = "item_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders = new ArrayList<>();
//
//    public void addOrder(Order order){
//        orders.add(order);
//    }



}
