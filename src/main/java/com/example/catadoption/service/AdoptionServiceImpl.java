package com.example.catadoption.service;

import com.example.catadoption.model.Adoption;
import com.example.catadoption.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    @Override
    public List<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }

    @Override
    public Adoption saveAdoption(Adoption adoption) {
        return adoptionRepository.save(adoption);
    }

    @Override
    public Adoption getAdoptionById(Long id) {
        return adoptionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAdoption(Long id) {
        adoptionRepository.deleteById(id);
    }
}
