package com.example.pfemed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String Typech;
    private int nbPlace;


    @OneToMany(mappedBy = "vehicule",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     List<Mission> Missions;
}
