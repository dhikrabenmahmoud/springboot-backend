package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise,Long> {
}
