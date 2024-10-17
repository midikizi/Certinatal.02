package com.example.Certinatal.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class LivretFammilleDTO {
    private Long id;
    private Instant date_ajout;

    private Long parentsId;
}
