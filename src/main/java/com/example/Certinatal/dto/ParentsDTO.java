package com.example.Certinatal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ParentsDTO {
    private  Long id;
    private String nom;

    private String prenom;

    private String type_parent;

    private int nationalité;

    private boolean is_declarant;

    private String profession;

    private String adresse;

    private String email;

    private List<EnfantDTO> enfantsId;
}
