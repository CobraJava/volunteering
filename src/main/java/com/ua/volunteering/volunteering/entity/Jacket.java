package com.ua.volunteering.volunteering.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jacket")
@AllArgsConstructor
@NoArgsConstructor
public class Jacket extends Clothes {

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "order_id")
    private Long orderId;

    @Builder
    public Jacket(Long id, String name, Size size, Long orderId) {
        super(id, name);
        this.size = size;
        this.orderId = orderId;
    }
}
