package com.ua.volunteering.volunteering.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "farmacetron")
@AllArgsConstructor
@NoArgsConstructor
public class Farmacetron extends Medicine {

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "order_id")
    private Long orderId;

    @Builder
    public Farmacetron(Long id, String name, String prescription, String dosage, Long orderId) {
        super(id,name, prescription);
        this.dosage = dosage;
        this.orderId = orderId;
    }
}
