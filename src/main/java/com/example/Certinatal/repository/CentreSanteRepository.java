package com.example.Certinatal.repository;

import com.example.Certinatal.models.CentreSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentreSanteRepository extends JpaRepository<CentreSante,Long> {
    @Query("SELECT cs.nomDistrictSanitaire, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "GROUP BY cs.nomDistrictSanitaire")
    List<Object[]> findNaissancesParCentreSante(@Param("mois") int mois, @Param("annee") int annee);

    @Query("SELECT cs.nomDistrictSanitaire, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "AND cs.nomDistrictSanitaire = :centreSanteNom " +
            "GROUP BY cs.nomDistrictSanitaire")
    List<Object[]> findNaissancesParCentreSante(@Param("mois") int mois, @Param("annee") int annee,
                                                @Param("centreSanteNom") String centreSanteNom);
}
