package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long> {
}
