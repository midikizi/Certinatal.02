package com.example.Certinatal.services;

import com.example.Certinatal.dto.QuartierCommuneDTO;

import java.util.List;

public interface QuartierService {
    QuartierCommuneDTO save(QuartierCommuneDTO quartierDTO);
    List<QuartierCommuneDTO> getAll();
    QuartierCommuneDTO update(QuartierCommuneDTO quartierDTO);
    void delete(Long id);
    QuartierCommuneDTO getById(Long id);
}
