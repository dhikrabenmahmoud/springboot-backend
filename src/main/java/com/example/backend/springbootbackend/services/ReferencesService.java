package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;

import java.util.List;

public interface ReferencesService {
    List<References> getAllReferences();
    References createReferences(References references);
    References updateReferences(References references);
    void deleteReferences(Long id);
    References getReferencesById(Long id);
}
