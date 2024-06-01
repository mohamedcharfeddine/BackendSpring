package com.example.pfemed.service;


import com.example.pfemed.models.Programme;
import com.example.pfemed.models.Projet;

import java.util.List;

public interface ProjetService {
    List<Projet> AllProjet();


    Projet updateProjet(Projet pr);

    Projet getProjetByid(Long idPr);

    Projet addProjet(Projet pr );

    void removeProjet(Long idPr);
}
