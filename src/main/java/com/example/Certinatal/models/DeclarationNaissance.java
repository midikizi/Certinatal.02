package com.example.Certinatal.models;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DeclarationNaissance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nbEnfantsVivants;

    private int nbEnfantsMorts;

    private boolean mariageEtatCivil;

    private boolean mariageCoutumier;

    private String type_naissance;

    private Instant date_declaration;

    private String statut_demande;

    @OneToOne
    private AttestationNaissance attestationNaissance;

    @OneToOne
    private Utilisateur agentMunicipal;

}