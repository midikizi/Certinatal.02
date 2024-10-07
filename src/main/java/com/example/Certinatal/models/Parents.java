package com.example.Certinatal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Parents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;

    private String prenom;

    private String type_parent;

    private int nationalité;

    private boolean is_declarant;

    private String profession;

    private String adresse;

    private String email;

    @OneToMany
    private List<Enfant> enfants;

}