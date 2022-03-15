package com.ua.volunteering.volunteering.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medicine")
public class Medicine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
