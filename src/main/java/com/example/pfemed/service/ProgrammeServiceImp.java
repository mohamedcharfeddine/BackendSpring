package com.example.pfemed.service;

import com.example.pfemed.models.Programme;
import com.example.pfemed.models.Projet;
import com.example.pfemed.repository.ProgrammeRepository;
import com.example.pfemed.repository.ProjetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeServiceImp implements ProgrammeService {
    @Autowired
    private ProgrammeRepository programmeRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public List<Programme> AllProgramme() {
        return programmeRepository.findAll();
    }

    @Override
    public Programme updateProgramme(Programme p) {
        return programmeRepository.save(p);
    }

    @Override
    public Programme getProgrammeByid(Long idP) {
        return programmeRepository.findById(idP).orElse(null);
    }

    @Override
    public Programme addProgramme(Programme p) {
        return programmeRepository.save(p);
    }

    @Transactional
    @Override
    public Programme affecterProgToProjet(Programme programme, Long idProjet) {
        Optional<Projet> optionalProjet = projetRepository.findById(idProjet);
        if (optionalProjet.isPresent()) {
            Projet projet = optionalProjet.get();
            // Ajouter le projet à la liste de projets du programme
            programme.getProjets().add(projet);
            // Mettre à jour le programme dans la base de données
        }
        return programmeRepository.save(programme);
    }


    @Override
    public void removeProgramme(Long idP) {
        programmeRepository.deleteById(idP);
    }


}
