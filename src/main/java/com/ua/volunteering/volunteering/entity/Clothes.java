package com.ua.volunteering.volunteering.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "clothes")
public class Clothes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

//    @ManyToOne
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    private Order order;


}
