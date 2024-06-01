package com.example.pfemed.service;

import com.example.pfemed.models.Programme;
import com.example.pfemed.models.Projet;
import com.example.pfemed.repository.ProgrammeRepository;
import com.example.pfemed.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetServiceImp implements ProjetService {
    @Autowired
    private ProjetRepository projetRepository;



    @Override
    public List<Projet> AllProjet() {
        return projetRepository.findAll();
    }


    @Override
    public Projet updateProjet(Projet pr) {
        return projetRepository.save(pr);
    }

    @Override
    public Projet getProjetByid(Long IdPr) {
        return projetRepository.findById(IdPr).orElse(null);
    }

    @Override
    public Projet addProjet(Projet pr) {
        return projetRepository.save(pr);
    }


    @Override
    public void removeProjet(Long IdPr) {
        projetRepository.deleteById(IdPr);

    }
}
