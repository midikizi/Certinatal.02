package com.example.Certinatal.repository;

import com.example.Certinatal.models.QuartierCommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierCommuneRepository extends JpaRepository <QuartierCommune,Long>{
}
