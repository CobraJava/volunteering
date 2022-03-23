package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}

