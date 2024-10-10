package com.example.Certinatal.services;

import com.example.Certinatal.dto.RegionDTO;

import java.util.List;

public interface RegionService {
    RegionDTO save(RegionDTO regionDTO);
    List<RegionDTO> getAll();
    RegionDTO update(RegionDTO regionDTO);
    void delete(Long id);
    RegionDTO getById(Long id);
}
