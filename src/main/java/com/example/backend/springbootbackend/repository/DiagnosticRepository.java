package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic,Long> {
}
