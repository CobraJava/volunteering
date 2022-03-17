package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
