package com.example.Certinatal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AttestationNaissanceDTO {
    private Long id;
    private int num_ref_demande;

    private Instant date_delivrance;
}
