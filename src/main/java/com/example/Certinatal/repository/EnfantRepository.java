package com.example.Certinatal.repository;

import com.example.Certinatal.models.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant,Long> {
    @Query("SELECT p.nom_prefecture, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.quartierCommune qc " +
            "JOIN qc.ville v " +
            "JOIN v.prefecture p " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "GROUP BY p.nom_prefecture")
    List<Object[]> findNaissancesParPrefecture(@Param("mois") int mois, @Param("annee") int annee);

    @Query("SELECT p.nom_prefecture, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.quartierCommune qc " +
            "JOIN qc.ville v " +
            "JOIN v.prefecture p " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "AND p.nom_prefecture = :prefectureNom " +
            "GROUP BY p.nom_prefecture")
    List<Object[]> findNaissancesParPrefecture(@Param("mois") int mois, @Param("annee") int annee,
                                               @Param("prefectureNom") String prefectureNom);


}

