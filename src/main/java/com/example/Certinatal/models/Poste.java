package com.example.Certinatal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String adresse;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
    private String contact;

    @OneToOne
    private QuartierCommune quartier_Commune;

}