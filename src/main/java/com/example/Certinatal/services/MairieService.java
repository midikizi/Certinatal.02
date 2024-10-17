package com.example.Certinatal.services;

import com.example.Certinatal.dto.MairieDTO;

import java.util.List;

public interface MairieService {
    MairieDTO save(MairieDTO mairieDTO);
    List<MairieDTO> getAll();
    MairieDTO update(MairieDTO mairieDTO);
    void delete(Long id);
    MairieDTO getById(Long id);
}

