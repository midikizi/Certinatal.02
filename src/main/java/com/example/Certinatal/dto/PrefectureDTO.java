package com.example.Certinatal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PrefectureDTO {
    private Long id;
    private String nom_prefecture;
    private Long regionId;
}
