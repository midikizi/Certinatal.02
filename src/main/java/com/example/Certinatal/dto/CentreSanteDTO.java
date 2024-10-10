package com.example.Certinatal.dto;

import com.example.Certinatal.models.Mairie;
import com.example.Certinatal.models.QuartierCommune;
import com.example.Certinatal.models.TypeCentre;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentreSanteDTO {
    private  Long id;
    private String nomDistrictDanitaire;
    private String adresse;
    private String contact;
    private Instant dateCreation;
    private String email;
//    private String password;
    private Long typeCentreId;
    private Long quartierCommuneId;

    private Long mairieId;
}
