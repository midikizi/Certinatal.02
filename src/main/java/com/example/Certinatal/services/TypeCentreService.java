package com.example.Certinatal.services;

import com.example.Certinatal.dto.TypeCentreDTO;

import java.util.List;

public interface TypeCentreService {
    TypeCentreDTO save(TypeCentreDTO typeCentreDTO);
    List<TypeCentreDTO> getAll();
    TypeCentreDTO update(TypeCentreDTO typeCentreDTO);
    void delete(Long id);
    TypeCentreDTO getById(Long id);
}
