package com.example.pfemed.service;

import com.example.pfemed.models.*;
import com.example.pfemed.repository.MissionRepository;
import com.example.pfemed.repository.UserRepository;
import com.example.pfemed.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MissionServiceImp implements MissionService {
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final VehiculeRepository vehiculeRepository;

    @Autowired
    public MissionServiceImp(MissionRepository missionRepository,
                             UserRepository userRepository,
                             VehiculeRepository vehiculeRepository) {
        this.missionRepository = missionRepository;
        this.userRepository = userRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public List<Mission> AllMission() {
        return missionRepository.findAll();
    }

    @Override
    public Mission updateMission(Mission m) {
        return missionRepository.save(m);
    }

    @Override
    public Mission getMissionByid(Long idM) {
        return missionRepository.findById(idM).orElse(null);
    }

    @Override
    public Mission addMission(Mission m , Long idU) {
        User u = userRepository.findById(idU).orElse(null );
        m.setEmployee(u);
        return missionRepository.save(m);
    }
    @Override
    public Mission acceptedM(Mission m , Long idm) {
        Mission mission = missionRepository.findById(idm ).orElse(null);
        mission.setEtat(Desicion.Accepter);
        return missionRepository.save(mission);
    }
    @Override
    public Mission refusedM(Mission m , Long idm) {
        Mission mission = missionRepository.findById(idm ).orElse(null);
        mission.setEtat(Desicion.Refuser);
        return missionRepository.save(mission);
    }
    @Override
    public Optional<Mission> missionByid(Long id) {
        return missionRepository.findById(id);
    }


    @Override
    public Mission affecterVehiculeMission(Mission mission, Long idV, Long idM) {
        // Retrieve the mission by idM
        Mission existingMission = missionRepository.findById(idM).orElse(null);
        Vehicule vehicle = vehiculeRepository.findById(idV).orElse(null);
        existingMission.setVehicule(vehicle);
        return missionRepository.save(existingMission);
    }



    @Override
    public void removeMission(Long idM) {
        missionRepository.deleteById(idM);
    }



    public List<Object[]> calculerPrixArticlesParMissionEtEmploye(Long missionId) {
        return missionRepository.calculerPrixArticlesParMissionEtEmploye(missionId);
    }

}
