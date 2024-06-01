package com.example.pfemed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private Long age;

    private Boolean enable = false;
    @Enumerated(EnumType.STRING)
    private Grade grade ;
    private String role;
    @JsonIgnore
    @OneToMany(mappedBy = "admin")
    List<Programme> programmes;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    List<Mission> missions;






}
