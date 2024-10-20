package com.example.Certinatal.models;
import java.time.Instant;

import com.example.Certinatal.Enum.TypeAccouchement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "enfant")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    private String Prenom;

    private String sexe;

    private Instant date_naissance;

    private Instant heure_naissance;

    private String lieu_naissance;

    private String Situation_matrimoniale_parents;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_accouchement", columnDefinition = "varchar(255)")
    private TypeAccouchement type_accouchement;

    @ManyToOne
    private CentreSante centreSante;

}