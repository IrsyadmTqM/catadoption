package com.example.catadoption.service;

import com.example.catadoption.model.Cat;
import com.example.catadoption.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getCatById(Long id) {
        return catRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Cat> findById(Long id) {
        return catRepository.findById(id);
    }

    @Override
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> filterCats(String name, String breed, String gender, Boolean adopted, Boolean validated) {
        return catRepository.findAll().stream()
            .filter(cat -> name == null || cat.getName().toLowerCase().contains(name.toLowerCase()))
            .filter(cat -> breed == null || breed.equals(cat.getBreed()))
            .filter(cat -> gender == null || gender.equals(cat.getGender()))
            .filter(cat -> adopted == null || adopted.equals(cat.isAdopted()))
            .filter(cat -> validated == null || validated.equals(cat.isValidated()))
            .collect(Collectors.toList());
    }
}
