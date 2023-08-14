package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.repository.ReferencesRepository;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ReferencesServiceImpl implements ReferencesService {

    @Autowired
    private ReferencesRepository referencesRepository;

    @Override
    public List<References> getAllReferences() {
        return referencesRepository.findAll();
    }

    @Override
    public References createReferences(ReferenceDTO references) {
        References ref = new References();
        // String delims = "[,]";
       //  String[] parts = references.getImage().split(delims);
       //  String imageString = parts[1];
       //  byte[] imageByteArray = Base64.getDecoder().decode(imageString);
        ref.setImage(references.getImage());
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

    @Override
    public References updateReferences(References references) {
        References existingReferences = referencesRepository.findById(references.getId()).get();

        existingReferences.setNomAr(references.getNomAr());
        existingReferences.setNomFr(references.getNomFr());
        existingReferences.setNomAn(references.getNomAn());
        existingReferences.setImage(references.getImage());
        existingReferences.setUpdatedBy("admin");
        existingReferences.setUpdatedDate(LocalDateTime.now());
        existingReferences.setOperation("UPDATE REFERENCES");
        existingReferences.setUtilisateur("admin");

        return referencesRepository.save(existingReferences);
    }

    @Override
    public void deleteReferences(Long id) {
        References references = referencesRepository.findById(id).get();

        references.setIsDeleted(1);
        references.setUpdatedBy("admin");
        references.setUpdatedDate(LocalDateTime.now());
        references.setOperation("DELETE References");
        references.setUtilisateur("admin");

        referencesRepository.save(references);
    }

    @Override
    public References getReferencesById(Long id) {
        return referencesRepository.findById(id).get();
    }
}
