package com.ua.volunteering.volunteering.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Clothes> clothes;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Medicine> medicineList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<ArmorVest> armorVestList;
}
