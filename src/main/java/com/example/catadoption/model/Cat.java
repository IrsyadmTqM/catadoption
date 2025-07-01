package com.example.catadoption.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String breed;
    private String gender;
    private String description;
    private String photo;
    private boolean validated;
    private boolean adopted;
}
