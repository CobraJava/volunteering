package com.ua.volunteering.volunteering.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "shoes")
@AllArgsConstructor
@NoArgsConstructor
public class Shoes extends Clothes {

    @Column(name = "size_uk")
    private Integer sizeUK;

    @Column(name = "order_id")
    private Long orderId;

    @Builder
    public Shoes(Long id, String name, Integer sizeUK, Long orderId) {
        super(id, name);
        this.sizeUK = sizeUK;
        this.orderId = orderId;
    }

}
