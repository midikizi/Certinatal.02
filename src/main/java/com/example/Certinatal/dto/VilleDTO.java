package com.example.Certinatal.dto;

import com.example.Certinatal.models.Prefecture;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VilleDTO {
    private Long id;
    private String nom_ville;
    private Long prefectureId;
}
