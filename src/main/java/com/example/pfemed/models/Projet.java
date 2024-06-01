package com.example.pfemed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomP ;
    private String description ;

    @JsonIgnore
    @ManyToMany(mappedBy = "projets")
    private List<Programme> programmes;
}
