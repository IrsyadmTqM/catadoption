package com.example.catadoption.repository;

import com.example.catadoption.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findAllByOrderByDateDesc();
}
