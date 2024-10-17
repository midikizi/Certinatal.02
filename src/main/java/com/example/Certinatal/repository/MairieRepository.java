package com.example.Certinatal.repository;

import com.example.Certinatal.models.Mairie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MairieRepository extends JpaRepository<Mairie,Long> {
    @Query("SELECT m.nom, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.mairie m " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "GROUP BY m.nom")
    List<Object[]> findNaissancesParMairie(@Param("mois") int mois, @Param("annee") int annee);

    @Query("SELECT m.nom, COUNT(e.id) as nbNaissances " +
            "FROM enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.mairie m " +
            "WHERE EXTRACT(MONTH FROM e.date_naissance) = :mois " +
            "AND EXTRACT(YEAR FROM e.date_naissance) = :annee " +
            "AND m.nom = :mairieNom " +
            "GROUP BY m.nom")
    List<Object[]> findNaissancesParMairie(@Param("mois") int mois, @Param("annee") int annee,
                                           @Param("mairieNom") String mairieNom);

}
