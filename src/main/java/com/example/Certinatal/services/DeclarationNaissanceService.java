package com.example.Certinatal.services;

import com.example.Certinatal.dto.DeclarationNaissanceDTO;

import java.util.List;

public interface DeclarationNaissanceService {
    DeclarationNaissanceDTO save(DeclarationNaissanceDTO declarationNaissanceDTO);
    List<DeclarationNaissanceDTO> getAll();
    DeclarationNaissanceDTO getById(Long id);
    DeclarationNaissanceDTO update(DeclarationNaissanceDTO declarationNaissanceDTO);
    void delete(Long id);
}

