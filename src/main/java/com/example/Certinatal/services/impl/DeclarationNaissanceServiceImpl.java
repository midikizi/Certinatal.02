package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.DeclarationNaissanceDTO;
import com.example.Certinatal.models.DeclarationNaissance;
import com.example.Certinatal.repository.DeclarationNaissanceRepository;
import com.example.Certinatal.services.DeclarationNaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationNaissanceServiceImpl implements DeclarationNaissanceService {

    @Autowired
    private DeclarationNaissanceRepository declarationNaissanceRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Convertir l'entité en DTO
    private DeclarationNaissanceDTO convertToDto(DeclarationNaissance declarationNaissance) {
        return modelMapper.map(declarationNaissance, DeclarationNaissanceDTO.class);
    }

    // Convertir le DTO en entité
    private DeclarationNaissance convertToEntity(DeclarationNaissanceDTO declarationNaissanceDTO) {
        return modelMapper.map(declarationNaissanceDTO, DeclarationNaissance.class);
    }

    @Override
    public DeclarationNaissanceDTO save(DeclarationNaissanceDTO declarationNaissanceDTO) {
        DeclarationNaissance declarationNaissance = convertToEntity(declarationNaissanceDTO);
        return convertToDto(declarationNaissanceRepository.save(declarationNaissance));
    }

    @Override
    public List<DeclarationNaissanceDTO> getAll() {
        return declarationNaissanceRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DeclarationNaissanceDTO getById(Long id) {
        return declarationNaissanceRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public DeclarationNaissanceDTO update(DeclarationNaissanceDTO declarationNaissanceDTO) {
        DeclarationNaissance declarationNaissance = convertToEntity(declarationNaissanceDTO);
        return convertToDto(declarationNaissanceRepository.save(declarationNaissance));
    }

    @Override
    public void delete(Long id) {
        declarationNaissanceRepository.deleteById(id);
    }
}

