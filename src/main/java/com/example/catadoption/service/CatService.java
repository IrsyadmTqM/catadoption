package com.example.catadoption.service;

import com.example.catadoption.model.Cat;
import java.util.List;
import java.util.Optional;

public interface CatService {
    List<Cat> getAllCats();

    Cat getCatById(Long id);

    Cat saveCat(Cat cat);

    void deleteCat(Long id);

    List<Cat> filterCats(String name, String breed, String gender, Boolean adopted, Boolean validated);

    // 🔽 Tambahkan ini
    Optional<Cat> findById(Long id);
}
