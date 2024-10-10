package com.example.Certinatal.services;

import com.example.Certinatal.dto.CentreSanteDTO;

import java.util.List;

public interface CentreSanteService {
    CentreSanteDTO save(CentreSanteDTO centreSanteDTO);
    List<CentreSanteDTO> getAll();
    CentreSanteDTO update(CentreSanteDTO centreSanteDTO);
    void delete(Long id);
    CentreSanteDTO getById(Long id);
}
