package com.example.catadoption.controller;

import com.example.catadoption.model.Cat;
import com.example.catadoption.service.CatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @Value("${upload.dir}")
    private String uploadDir;

    @GetMapping
    public String listCats(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String breed,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String validated,
            @RequestParam(required = false) String adopted,
            Model model) {

        breed = (breed == null || breed.isEmpty()) ? null : breed;
        gender = (gender == null || gender.isEmpty()) ? null : gender;
        Boolean isValidated = (validated == null || validated.isEmpty()) ? null : Boolean.valueOf(validated);
        Boolean isAdopted = (adopted == null || adopted.isEmpty()) ? null : Boolean.valueOf(adopted);
        name = (name == null || name.isBlank()) ? null : name.trim();

        model.addAttribute("cats", catService.filterCats(name, breed, gender, isAdopted, isValidated));
        model.addAttribute("searchName", name);
        model.addAttribute("selectedBreed", breed);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("selectedAdopted", isAdopted);
        model.addAttribute("selectedValidated", isValidated);

        return "cat/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "cat/form";
    }

    @PostMapping
    public String saveCat(@ModelAttribute Cat cat,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            File uploadPath = new File(System.getProperty("user.dir"), uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            File destination = new File(uploadPath, fileName);
            file.transferTo(destination);

            cat.setPhoto(fileName);
        }

        catService.saveCat(cat);
        return "redirect:/cats";
    }

    @GetMapping("/{id}")
    public String detailCat(@PathVariable Long id, Model model) {
        model.addAttribute("cat", catService.getCatById(id));
        return "cat/detail";
    }

    @GetMapping("/{id}/edit")
    public String editCat(@PathVariable Long id, Model model) {
        model.addAttribute("cat", catService.getCatById(id));
        return "cat/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return "redirect:/cats";
    }

    @PostMapping("/{id}/validate")
    public String validateCat(@PathVariable Long id) {
        Cat cat = catService.getCatById(id);
        cat.setValidated(true);
        catService.saveCat(cat);
        return "redirect:/cats/" + id;
    }

    @PostMapping("/{id}/adopt")
    public String markAsAdopted(@PathVariable Long id) {
        Cat cat = catService.getCatById(id);
        cat.setAdopted(true);
        catService.saveCat(cat);
        return "redirect:/cats/" + id;
    }

}
