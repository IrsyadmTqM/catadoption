package com.example.catadoption.service;

import com.example.catadoption.model.Cat;
import com.example.catadoption.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
