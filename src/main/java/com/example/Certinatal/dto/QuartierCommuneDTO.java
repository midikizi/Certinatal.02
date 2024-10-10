package com.example.Certinatal.dto;

import com.example.Certinatal.models.Ville;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class QuartierCommuneDTO {
    private Long id;
    private String nom_Quartier;
    private Long villeId;
}
