package com.example.pfemed.controller;


import com.example.pfemed.models.Programme;

import com.example.pfemed.models.Projet;
import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.ProgrammeRepository;
import com.example.pfemed.service.ProgrammeService;
import com.example.pfemed.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Programme")
public class ProgrammeController {
    private ProgrammeService programmeService;
    private ProjetService projetService;
    private ProgrammeRepository programmeRepository;


    @PutMapping("/projetstoprogramme/{programmeId}/{projetId}")
    public ResponseEntity<Programme> affecterProjetAuProgramme(@PathVariable Long programmeId, @PathVariable Long projetId) {
        Programme programme = programmeService.getProgrammeByid(programmeId);
        if (programme == null) {
            return ResponseEntity.notFound().build();
        }
        Programme programmeAffecte = programmeService.affecterProgToProjet(programme, projetId);
        return ResponseEntity.status(HttpStatus.CREATED).body(programmeAffecte);
    }


    @PostMapping("/add")
    public ResponseEntity<Programme> addProgramme(@RequestBody Programme p) {
        Programme addedProgramme = programmeService.addProgramme(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProgramme);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Programme>> getAllProgramme() {
        List<Programme> P = programmeService.AllProgramme();
        return ResponseEntity.ok(P);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable Long id, @RequestBody Programme p) {
        return programmeRepository.findById(id)
                .map(existingProgramme -> {

                    existingProgramme.setDateD(p.getDateD());
                    existingProgramme.setDateF(p.getDateF());
                    Programme updatedProgramme = programmeRepository.save(existingProgramme);
                    return ResponseEntity.ok(updatedProgramme);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProgramme(@PathVariable Long id) {
        try {
            programmeService.removeProgramme(id);
            return ResponseEntity.ok("Programme deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete programme");
        }
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable Long id) {
        Programme programme = programmeService.getProgrammeByid(id);
        return ResponseEntity.ok(programme);
    }


}
