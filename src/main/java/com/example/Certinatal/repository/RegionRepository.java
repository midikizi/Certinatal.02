package com.example.Certinatal.repository;

import com.example.Certinatal.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
}
