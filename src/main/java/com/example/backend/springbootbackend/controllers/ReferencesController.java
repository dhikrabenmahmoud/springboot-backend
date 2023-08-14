package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ProductService;
import com.example.backend.springbootbackend.services.ReferencesService;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ReferencesController {
    @Autowired
    ReferencesService referencesService;

    @GetMapping(value = "/reference")
    public List<References> getAllReferences() {
        return  referencesService.getAllReferences();
    }

    @PostMapping("/reference")
    public References createReferences(@RequestBody ReferenceDTO references) {
        return referencesService.createReferences(references);
    }


    @PutMapping("/reference/{id}")
    public References updateReferences(@PathVariable Long id, @RequestBody References references) {
        references.setId(id);
        References  updateReferences = referencesService.updateReferences(references);
        if ( updateReferences == null) {
            throw new RessourceNotFoundException("References with ID " + id + " not found.");
        }
        return updateReferences;
    }

    @DeleteMapping("/reference/{id}")
    public void deleteReferences(@PathVariable Long id) {
        referencesService.deleteReferences(id);
    }
    @GetMapping("/reference/{id}")
    public References getReferencesById(@PathVariable Long id) {
        return referencesService.getReferencesById(id);
    }



}
