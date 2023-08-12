package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Actualites;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ActualitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActualitesServiceImpl implements ActualitesService{

    @Autowired
    private ActualitesRepository actualitesRepository;


    public List<Actualites> getAllActualites(){
        return actualitesRepository.findAll();
    }
    public Actualites createActualites(Actualites actualites) {
        actualites.setCreatedBy("admin");
        actualites.setCreatedDate(LocalDateTime.now());
        actualites.setIsDeleted(0);
        actualites.setOperation("SAVE ACTUALITES");
        actualites.setUtilisateur("admin");
        return actualitesRepository.save(actualites);
    }

    public Actualites updateActualites(Actualites actualites) {
        Actualites existingActualites = actualitesRepository.findById(actualites.getId()).orElse(null);

        if (existingActualites != null) {
            existingActualites.setLibAr(actualites.getLibAr());
            existingActualites.setLibFr(actualites.getLibFr());
            existingActualites.setLibAn(actualites.getLibAn());
            existingActualites.setUpdatedBy("admin");
            existingActualites.setUpdatedDate(LocalDateTime.now());
            existingActualites.setOperation("UPDATE ACTUALITES ");
            existingActualites.setUtilisateur("admin");

            return actualitesRepository.save(existingActualites);
        } else {
             return null;
        }
    }

    public void deleteActualites(Long id) {
        Optional<Actualites> existingActualites = actualitesRepository.findById(id);
        if (existingActualites.isPresent()) {
            Actualites  actualites = existingActualites.get();
            actualites.setIsDeleted(1);
            actualites.setUpdatedBy("admin");
            actualites.setUpdatedDate(LocalDateTime.now());
            actualites.setOperation("DELETE ACTUALITES");
            actualites.setUtilisateur("admin");

            actualitesRepository.save(actualites);
        } else {
            throw new RessourceNotFoundException("actualites with ID " + id + " not found.");
        }
    }

    public Actualites getActualitesById(Long id) {
        return actualitesRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("actualites with ID " + id + " not found.")
        );
    }
}
