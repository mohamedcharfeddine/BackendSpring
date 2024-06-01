package com.example.pfemed.controller;

import com.example.pfemed.models.Mission;
import com.example.pfemed.models.Projet;
import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.VehiculeRepository;
import com.example.pfemed.service.VehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Vehicule")
public class VehiculeController {
    private VehiculeService vehiculeService;
    private VehiculeRepository vehiculeRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> V = vehiculeService.AllVehicule();
        return ResponseEntity.ok(V);
    }
    @PostMapping("/add")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule v )
    {
        Vehicule addedVehicule = vehiculeService.addVehicule(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedVehicule);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule v) {
        return vehiculeRepository.findById(id)
            .map(existingVehicule -> {
                existingVehicule.setMatricule(v.getMatricule());
                existingVehicule.setTypech(v.getTypech());
                existingVehicule.setNbPlace(v.getNbPlace());

                Vehicule updatedVehicule = vehiculeRepository.save(existingVehicule);
                return ResponseEntity.ok(updatedVehicule);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicule(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
        return ResponseEntity.ok("Vehicule deleted successfully");
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.getVehiculeByid(id);
        return ResponseEntity.ok(vehicule);
    }
}
