package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs,Long> {
}
