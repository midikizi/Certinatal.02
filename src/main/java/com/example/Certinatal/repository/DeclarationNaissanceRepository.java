package com.example.Certinatal.repository;

import com.example.Certinatal.models.DeclarationNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeclarationNaissanceRepository extends JpaRepository<DeclarationNaissance, Long> {
    @Query("SELECT m.nom, COUNT(d.id) as nbDeclarations " +
            "FROM DeclarationNaissance d " +
            "JOIN d.attestationNaissance an " +
            "JOIN an.enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.mairie m " +
            "WHERE EXTRACT(MONTH FROM d.date_declaration) = :mois " +
            "AND EXTRACT(YEAR FROM d.date_declaration) = :annee " +
            "GROUP BY m.nom")
    List<Object[]> findDeclarationsParMairie(@Param("mois") int mois, @Param("annee") int annee);

    @Query("SELECT m.nom, COUNT(d.id) as nbDeclarations " +
            "FROM DeclarationNaissance d " +
            "JOIN d.attestationNaissance an " +
            "JOIN an.enfant e " +
            "JOIN e.centreSante cs " +
            "JOIN cs.mairie m " +
            "WHERE EXTRACT(MONTH FROM d.date_declaration) = :mois " +
            "AND EXTRACT(YEAR FROM d.date_declaration) = :annee " +
            "AND m.nom = :mairieNom " +
            "GROUP BY m.nom")
    List<Object[]> findDeclarationsParMairie(@Param("mois") int mois, @Param("annee") int annee,
                                             @Param("mairieNom") String mairieNom);


}
