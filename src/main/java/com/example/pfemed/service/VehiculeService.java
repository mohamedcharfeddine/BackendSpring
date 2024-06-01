package com.example.pfemed.service;


import com.example.pfemed.models.Vehicule;

import java.util.List;

public interface VehiculeService {
    List<Vehicule> AllVehicule();

    Vehicule updateVehicule(Vehicule v);

    Vehicule getVehiculeByid(Long idV);

    Vehicule addVehicule(Vehicule v);

    void removeVehicule(Long idV);
}
