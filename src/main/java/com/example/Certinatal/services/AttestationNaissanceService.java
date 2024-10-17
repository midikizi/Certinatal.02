package com.example.Certinatal.services;

import com.example.Certinatal.dto.AttestationNaissanceDTO;

import java.util.List;

public interface AttestationNaissanceService {
    AttestationNaissanceDTO save(AttestationNaissanceDTO attestationDTO);
    List<AttestationNaissanceDTO> getAll();
    AttestationNaissanceDTO update(AttestationNaissanceDTO attestationDTO);
    void delete(Long id);
    AttestationNaissanceDTO getById(Long id);
}
