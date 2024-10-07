package com.example.Certinatal.models;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CentreSante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom_district_sanitaire;

    private String adresse;

    private String contact;

    private Instant date_creation;

    @ManyToOne
    private TypeCentre typeCentre;

    @ManyToOne
    private QuartierCommune quartier_Commune;

    @ManyToOne
    private Mairie mairie;
}