package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Paracetamol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParacetamolRepository extends JpaRepository<Paracetamol, Long> {
}

