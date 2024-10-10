package com.example.Certinatal.repository;

import com.example.Certinatal.models.CentreSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreSanteRepository extends JpaRepository<CentreSante,Long> {
}
