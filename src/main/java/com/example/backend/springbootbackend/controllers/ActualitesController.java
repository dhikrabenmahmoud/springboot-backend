package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Actualites;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ActualitesService;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ActualitesController {
    @Autowired
    ActualitesService actualitesService;

    @GetMapping(value = "/actualites")
    public List<Actualites> getAllActualites() {
        return actualitesService.getAllActualites();
    }

    @PostMapping("/actualites")
    public Actualites createActualites(@RequestBody Actualites actualites) {
        return actualitesService.createActualites(actualites);
    }

    @PutMapping("/actualites/{id}")
    public Actualites updateActualites(@PathVariable Long id, @RequestBody Actualites actualites) {
        actualites.setId(id);
        Actualites updateActualites = actualitesService.updateActualites(actualites);
        if (updateActualites == null) {
            throw new RessourceNotFoundException("actualites with ID " + id + " not found.");
        }
        return updateActualites;
    }

    @DeleteMapping("/actualites/{id}")
    public void deleteActualites(@PathVariable Long id) {
        actualitesService.deleteActualites(id);
    }
    @GetMapping("/actualites/{id}")
    public Actualites getActualitesById(@PathVariable Long id) {
        return actualitesService.getActualitesById(id);
    }
}
