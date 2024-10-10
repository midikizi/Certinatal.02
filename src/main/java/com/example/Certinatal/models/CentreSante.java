package com.example.Certinatal.models;
import java.time.Instant;

import jakarta.persistence.*;
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
    private String nomDistrictSanitaire;
    private String adresse;
    private String contact;
    private Instant dateCreation;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @ManyToOne
    private TypeCentre typeCentre;

    @ManyToOne
    private QuartierCommune quartierCommune;

    @ManyToOne
    private Mairie mairie;
}