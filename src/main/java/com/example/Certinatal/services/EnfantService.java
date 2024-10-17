package com.example.Certinatal.services;

import com.example.Certinatal.dto.EnfantDTO;

import java.util.List;

public interface EnfantService {
    EnfantDTO save(EnfantDTO enfantDTO);
    List<EnfantDTO> getAll();
    EnfantDTO update(EnfantDTO enfantDTO);
    void delete(Long id);
    EnfantDTO getById(Long id);
}
