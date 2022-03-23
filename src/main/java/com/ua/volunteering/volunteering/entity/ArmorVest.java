package com.ua.volunteering.volunteering.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "armor_vest")
public class ArmorVest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "protection")
    @NotNull
    private Integer protection;
}
