package com.example.pfemed.controller;


import com.example.pfemed.models.Programme;
import com.example.pfemed.models.Projet;
import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.ProjetRepository;
import com.example.pfemed.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Projet")
public class ProjetController {
    private ProjetService projetService;
    private ProjetRepository projetRepository;

    @PostMapping("/add")
    public ResponseEntity<Projet> addProjet(@RequestBody Projet pr)
    {
        Projet addedProjet = projetService.addProjet(pr);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProjet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjet() {
        List<Projet> Pr = projetService.AllProjet();
        return ResponseEntity.ok(Pr);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet pr) {
        return projetRepository.findById(id)
            .map(existingProjet -> {
                existingProjet.setNomP(pr.getNomP());
                existingProjet.setDescription(pr.getDescription());


                Projet updatedProjet = projetRepository.save(existingProjet);
                return ResponseEntity.ok(updatedProjet);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProjet(@PathVariable Long id) {
        projetService.removeProjet(id);
        return ResponseEntity.ok("Projet deleted successfully");
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Projet projet = projetService.getProjetByid(id);
        return ResponseEntity.ok(projet);
    }

}
