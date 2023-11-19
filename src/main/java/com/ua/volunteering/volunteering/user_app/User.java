package com.ua.volunteering.volunteering.user_app;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "age")
    @NotNull
    private Integer age;

    @Column(name = "role")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "country")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "experience")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Experience experience;

    @Column(name = "salary_expectation")
    @NotNull
    private Integer salaryExpectation;

    @Column(name = "english_level")
    @NotNull
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;

    @Column(name = "career")
    @NotNull
    private String linkToCVorLinkedIn;

}
