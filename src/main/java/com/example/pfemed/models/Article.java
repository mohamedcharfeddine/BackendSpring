package com.example.pfemed.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Categorie categorie ;
    private Double  prix  ;
    @Enumerated(EnumType.STRING)
    private Desicion etat ;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    private Mission mission;


}
