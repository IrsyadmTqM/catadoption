package com.example.catadoption.service;

import com.example.catadoption.model.Cat;
import java.util.List;

public interface CatService {
    List<Cat> getAllCats();
    Cat getCatById(Long id);
    Cat saveCat(Cat cat);
    void deleteCat(Long id);
}
