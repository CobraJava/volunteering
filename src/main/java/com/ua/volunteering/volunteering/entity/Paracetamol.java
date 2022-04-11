package com.ua.volunteering.volunteering.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "paracetamol")
@AllArgsConstructor
@NoArgsConstructor
public class Paracetamol extends Medicine {

    @Column(name = "description")
    private String description;

    @Column(name = "order_id")
    private Long orderId;

    @Builder
    public Paracetamol(Long id, String name, String prescription, String description, Long orderId) {
        super(id,name, prescription);
        this.description = description;
        this.orderId = orderId;
    }

}
