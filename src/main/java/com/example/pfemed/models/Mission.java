package com.example.pfemed.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data

public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lieu ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateD ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateF ;
    @Enumerated(EnumType.STRING)
    private  Desicion etat ;
    private  String description ;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private User employee;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;

    @JsonIgnore
    @OneToMany(mappedBy = "mission")
    private List<Article> articles;


}
