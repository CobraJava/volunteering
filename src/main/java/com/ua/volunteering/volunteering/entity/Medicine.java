package com.ua.volunteering.volunteering.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "prescription")
    @NotNull
    private String prescription;

}
