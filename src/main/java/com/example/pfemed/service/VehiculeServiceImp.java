package com.example.pfemed.service;

import com.example.pfemed.models.Vehicule;
import com.example.pfemed.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehiculeServiceImp implements VehiculeService{
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Override
    public List<Vehicule> AllVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule getVehiculeByid(Long idV) {
        return vehiculeRepository.findById(idV).orElse(null);
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public void removeVehicule(Long idV) {
        vehiculeRepository.deleteById(idV);
    }
}
