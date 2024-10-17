package com.example.Certinatal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class EnfantDTO {
    private Long id;
    private String nom;

    private String Prenom;

    private String sexe;

    private Instant date_naissance;

    private Instant heure_naissance;

    private String lieu_naissance;

    private String Situation_matrimoniale_parents;

    private Long centreSanteId;

    private String type_accouchement;
}
