package com.example.pfemed.controller;

import com.example.pfemed.models.Mission;
import com.example.pfemed.models.Programme;
import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.MissionRepository;
import com.example.pfemed.service.MissionService;
import com.example.pfemed.service.VehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Mission")
public class MissionController {
    private MissionService missionService;
    private VehiculeService vehiculeService ;
    private MissionRepository missionRepository ;

    @PostMapping("/add/{idU}")
    public ResponseEntity<Mission> addMission(@RequestBody Mission m  , @PathVariable Long idU)
    {
        Mission addedMission = missionService.addMission(m , idU);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMission);
    }
    @PutMapping("/affectVehiculeMission/{idV}/{idM}")
    public ResponseEntity<Mission> affectVehiculeMission(@PathVariable Long idV, @PathVariable Long idM) {
        try {
            Mission mission = missionService.getMissionByid(idM);
            if (mission == null) {
                return ResponseEntity.notFound().build();
            }
            Vehicule vehicle = vehiculeService.getVehiculeByid(idV);
            if (vehicle == null) {
                return ResponseEntity.notFound().build();
            }
            mission.setVehicule(vehicle);
            Mission updatedMission = missionRepository.save(mission);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedMission);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<Mission>> getAllMission() {
        List<Mission> M = missionService.AllMission();
        return ResponseEntity.ok(M);
    }
    @PutMapping("/acceptMission/{idm}")
    public ResponseEntity<Mission> acceptMission(@RequestBody Mission m , @PathVariable Long idm) {
        Mission updatedMission = missionService.acceptedM(m ,idm);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMission);
    }

    @PutMapping("/refuseMission/{idm}")
    public ResponseEntity<Mission> refuseMission(@RequestBody Mission m,  @PathVariable Long idm) {
        Mission updatedMission = missionService.refusedM (m,idm);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMission);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable Long id, @RequestBody Mission m) {
        return missionRepository.findById(id)
            .map(existingMission -> {
                existingMission.setLieu(m.getLieu());
                existingMission.setDateD(m.getDateD());
                existingMission.setDateF(m.getDateF());
                Mission updatedMission = missionRepository.save(existingMission);
                return ResponseEntity.ok(updatedMission);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }






    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
        try {
            missionService.removeMission(id);
            return ResponseEntity.ok("Mission deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete mission");
        }
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable Long id) {
        Mission Mission = missionService.getMissionByid(id);
        return ResponseEntity.ok(Mission);
    }
    @GetMapping("/prixArticlesParMissionEtEmploye/{missionId}")
    public List<Object[]> getPrixArticlesParMissionEtEmploye(@PathVariable Long missionId) {
        return missionService.calculerPrixArticlesParMissionEtEmploye(missionId);
    }

}
