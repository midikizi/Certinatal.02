package com.example.Certinatal.dto;

import com.example.Certinatal.models.QuartierCommune;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PosteDTO {
    private Long id;
    private String libelle;
    private String adresse;
    private String email;
//    private String password;
    private String contact;
    private Long quartier_Commune;
}
