package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Farmacetron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmacetronRepository extends JpaRepository<Farmacetron, Long> {
}
