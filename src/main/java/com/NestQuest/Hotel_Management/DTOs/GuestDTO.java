package com.NestQuest.Hotel_Management.DTOs;

import com.NestQuest.Hotel_Management.Entities.Enums.Gender;
import com.NestQuest.Hotel_Management.Entities.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class GuestDTO {

    private Long id;


    private User user;

    private String name;



    private Gender gender;

    private Integer age;
}
