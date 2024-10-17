package com.example.Certinatal.repository;

import com.example.Certinatal.models.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepository extends JpaRepository<Parents,Long> {
}
