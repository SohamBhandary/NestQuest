package com.NestQuest.Hotel_Management.Entities;

import com.NestQuest.Hotel_Management.Entities.Enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String name;


    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private Integer age;


}
