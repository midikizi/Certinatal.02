package com.example.Certinatal.repository;

import com.example.Certinatal.models.Mairie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MairieRepository extends JpaRepository<Mairie,Long> {
}
