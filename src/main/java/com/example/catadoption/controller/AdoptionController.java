package com.example.catadoption.controller;

import com.example.catadoption.model.Adoption;
import com.example.catadoption.model.Cat;
import com.example.catadoption.service.AdoptionService;
import com.example.catadoption.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @Autowired
    private CatService catService;

    @GetMapping
    public String showAdoptionHistory(Model model) {
        List<Adoption> adoptions = adoptionService.getAllAdoptions();
        model.addAttribute("adoptions", adoptions);
        return "adoption/history"; // pastikan file ini ada
    }

    @GetMapping("/new")
    public String showAdoptionForm(Model model) {
        model.addAttribute("adoption", new Adoption());
        model.addAttribute("cats", catService.getAllCats());
        return "adoption/form";
    }

    @PostMapping
    public String saveAdoption(
            @ModelAttribute Adoption adoption,
            @RequestParam("cat.id") Long catId) {

        Cat adoptedCat = catService.getCatById(catId);
        if (adoptedCat == null) {
            return "redirect:/adoptions/new?error=catNotFound";
        }

        adoptedCat.setAdopted(true);
        catService.saveCat(adoptedCat);

        adoption.setCat(adoptedCat);
        adoption.setDate(LocalDate.now());
        adoptionService.saveAdoption(adoption);

        return "redirect:/adoptions";
    }
}
