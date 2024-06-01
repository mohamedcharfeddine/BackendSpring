package com.example.pfemed.service;

import com.example.pfemed.models.Mission;


import java.util.List;
import java.util.Optional;

public interface MissionService {
    List<Mission> AllMission();

    Mission updateMission(Mission m);

    Mission getMissionByid(Long idM);

    Mission addMission(Mission m , Long idU);
    Optional<Mission> missionByid(Long id) ;
    Mission affecterVehiculeMission(Mission m, Long idV , Long idM);

    void removeMission(Long idM);
    Mission acceptedM(Mission m , Long idm);
    Mission refusedM(Mission m ,  Long idm);

    List<Object[]> calculerPrixArticlesParMissionEtEmploye(Long missionId);
}
