package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
