package com.example.Certinatal.repository;

import com.example.Certinatal.models.AttestationNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttestationNaissanceRepository extends JpaRepository<AttestationNaissance,Long> {

}
