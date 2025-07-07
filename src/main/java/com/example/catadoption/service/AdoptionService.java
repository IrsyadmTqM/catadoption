package com.example.catadoption.service;

import com.example.catadoption.model.Adoption;

import java.util.List;

public interface AdoptionService {
    List<Adoption> getAllAdoptions();
    Adoption saveAdoption(Adoption adoption);
    Adoption getAdoptionById(Long id);
    void deleteAdoption(Long id);
}
