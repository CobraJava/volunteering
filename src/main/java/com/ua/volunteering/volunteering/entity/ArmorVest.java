package com.ua.volunteering.volunteering.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "armor_vest")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "order_id")
    private Long orderId;
}
