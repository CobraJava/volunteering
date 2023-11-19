package com.ua.volunteering.volunteering.user_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("SELECT c FROM User c WHERE (:country is null or c.country = :country)" +
            " and (:role is null or c.role = :role)" +
            " and (:experience is null or c.experience = :experience)" +
            " and (:englishLevel is null or c.englishLevel = :englishLevel)")
    List<User> findAllByCountryAndRole(@Param("country") Country country, @Param("role") Role role, @Param("experience") Experience experience, @Param("englishLevel") EnglishLevel englishLevel);

}
