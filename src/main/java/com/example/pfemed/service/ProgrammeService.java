package com.example.pfemed.service;

import com.example.pfemed.models.Programme;


import java.util.List;

public interface ProgrammeService {
    List<Programme> AllProgramme();

    Programme updateProgramme(Programme p);

    Programme getProgrammeByid(Long idP);

    Programme addProgramme(Programme p);
    Programme affecterProgToProjet(Programme p , Long idProjet);

    void removeProgramme(Long idP);



}
