package com.example.Certinatal.repository;

import com.example.Certinatal.models.Prefecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefectureRepository extends JpaRepository<Prefecture,Long> {
}
