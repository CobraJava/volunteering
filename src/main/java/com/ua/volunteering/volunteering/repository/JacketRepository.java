package com.ua.volunteering.volunteering.repository;

import com.ua.volunteering.volunteering.entity.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long> {

}
