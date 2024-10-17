package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.AttestationNaissanceDTO;
import com.example.Certinatal.models.AttestationNaissance;
import com.example.Certinatal.repository.AttestationNaissanceRepository;
import com.example.Certinatal.services.AttestationNaissanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttestationNaissanceServiceImpl implements AttestationNaissanceService {

    @Autowired
    private AttestationNaissanceRepository attestationNaissanceRepository;
    @Autowired
    private ModelMapper modelMapper;

    private AttestationNaissanceDTO convertToDto(AttestationNaissance attestationNaissance) {
        return modelMapper.map(attestationNaissance, AttestationNaissanceDTO.class);
    }

    private AttestationNaissance convertToEntity(AttestationNaissanceDTO attestationNaissanceDTO) {
        return modelMapper.map(attestationNaissanceDTO, AttestationNaissance.class);
    }

    public AttestationNaissanceDTO save(AttestationNaissanceDTO attestationNaissanceDTO) {
        AttestationNaissance attestationNaissance = convertToEntity(attestationNaissanceDTO);
        return convertToDto(attestationNaissanceRepository.save(attestationNaissance));
    }

    public List<AttestationNaissanceDTO> getAll() {
        return attestationNaissanceRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AttestationNaissanceDTO getById(Long id) {
        return attestationNaissanceRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public AttestationNaissanceDTO update(AttestationNaissanceDTO attestationNaissanceDTO) {
        AttestationNaissance attestationNaissance = convertToEntity(attestationNaissanceDTO);
        return convertToDto(attestationNaissanceRepository.save(attestationNaissance));
    }

    public void delete(Long id) {
        attestationNaissanceRepository.deleteById(id);
    }
}

