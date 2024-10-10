package com.example.Certinatal.repository;

import com.example.Certinatal.models.TypeCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCentreRepository extends JpaRepository<TypeCentre,Long> {
}
