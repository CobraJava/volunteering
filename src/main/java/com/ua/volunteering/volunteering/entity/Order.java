package com.ua.volunteering.volunteering.entity;

import lombok.Data;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Clothes> clothes;

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "order_id")
//    private List<Medicine> medicineList;
//
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "order_id")
//    private List<ArmorVest> armorVestList;
}
