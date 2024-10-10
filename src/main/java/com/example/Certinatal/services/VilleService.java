package com.example.Certinatal.services;

import com.example.Certinatal.dto.VilleDTO;

import java.util.List;

public interface VilleService {
    VilleDTO save(VilleDTO villeDTO);
    List<VilleDTO> getAll();
    VilleDTO update(VilleDTO villeDTO);
    void delete(Long id);
    VilleDTO getById(Long id);
}
