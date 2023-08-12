package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Actualites;


import java.util.List;

public interface ActualitesService {

    List<Actualites> getAllActualites();
    Actualites createActualites(Actualites actualites);
    Actualites updateActualites(Actualites actualites);
    void deleteActualites(Long id);
    Actualites getActualitesById(Long id);}
