package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ReferencesRepository;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
@Service
public class ReferencesServiceImpl implements ReferencesService{
    @Autowired
    private ReferencesRepository referencesRepository;


    public List<References> getAllReferences(){
        return referencesRepository.findAll();
    }
    public References createReferences(ReferenceDTO references) {
        References ref = new References();
        String delims = "[,]";
        String[] parts = references.getImage().split(delims);
        String imageString = parts[1];
        byte[] imageByteArray = Base64.getDecoder().decode(imageString);
         ref.setImage(imageByteArray);
         ref.setNomFr(references.getNomFr());
        ref.setNomAn(references.getNomAn());
        ref.setNomAr(references.getNomAr());
        ref.setCreatedBy("admin");
        ref.setCreatedDate(LocalDateTime.now());
        ref.setIsDeleted(0);
        ref.setOperation("SAVE REFERENCES");
        ref.setUtilisateur("admin");
        return referencesRepository.save(ref);
    }



    public References updateReferences(References references) {
        References existingReferences = referencesRepository.findById(references.getId()).orElse(null);

        if (existingReferences != null) {
            existingReferences.setNomAr(references.getNomAr());
            existingReferences.setNomFr(references.getNomFr());
            existingReferences.setNomAn(references.getNomAn());
            existingReferences.setImage(references.getImage());
            existingReferences.setUpdatedBy("admin");
            existingReferences.setUpdatedDate(LocalDateTime.now());
            existingReferences.setOperation("UPDATE REFERENCES");
            existingReferences.setUtilisateur("admin");

            return referencesRepository.save(existingReferences);
        } else {
            // Gérer le cas où lrefernce n'existe pas
            return null;
        }
    }

    public void deleteReferences(Long id) {
        Optional<References> existingReferences = referencesRepository.findById(id);
        if (existingReferences.isPresent()) {
            References references = existingReferences.get();
            references.setIsDeleted(1);
            references.setUpdatedBy("admin");
            references.setUpdatedDate(LocalDateTime.now());
            references.setOperation("DELETE References");
            references.setUtilisateur("admin");

            referencesRepository.save(references);
        } else {
            throw new RessourceNotFoundException("References with ID " + id + " not found.");
        }
    }

    public References getReferencesById(Long id) {
        return referencesRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("References with ID " + id + " not found.")
        );
    }

}
