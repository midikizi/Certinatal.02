package com.example.Certinatal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DeclarationNaissanceDTO {
    private Long id;
    private int nbEnfantsVivants;

    private int nbEnfantsMorts;

    private boolean mariageEtatCivil;

    private boolean mariageCoutumier;

    private Instant date_declaration;

    private String statut_demande;

    private Long type_naissanceId;

    private Long enfantId;

    private Long declarantId;

    private Long attestationNaissanceId;

    private Long agentMunicipalId;
}
