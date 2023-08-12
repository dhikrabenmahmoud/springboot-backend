package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.Actualites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualitesRepository extends JpaRepository<Actualites,Long> {
}
