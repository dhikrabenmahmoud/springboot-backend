package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;

import java.util.List;

public interface ReferencesService {
    List<References> getAllReferences();
    References createReferences(ReferenceDTO references);
    References updateReferences(ReferenceDTO references);
    void deleteReferences(Long id);
    References getReferencesById(Long id);
}
