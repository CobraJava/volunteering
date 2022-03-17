package com.ua.volunteering.volunteering.entity;

import lombok.Data;
import lombok.ToString;

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

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;




}
