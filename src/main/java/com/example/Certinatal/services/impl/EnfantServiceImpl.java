package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.EnfantDTO;
import com.example.Certinatal.models.Enfant;
import com.example.Certinatal.repository.EnfantRepository;
import com.example.Certinatal.services.EnfantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnfantServiceImpl implements EnfantService {

    @Autowired
    private EnfantRepository enfantRepository;
    @Autowired
    private ModelMapper modelMapper;

    private EnfantDTO convertToDto(Enfant enfant) {
        return modelMapper.map(enfant, EnfantDTO.class);
    }

    private Enfant convertToEntity(EnfantDTO enfantDTO) {
        return modelMapper.map(enfantDTO, Enfant.class);
    }

    public EnfantDTO save(EnfantDTO enfantDTO) {
        Enfant enfant = convertToEntity(enfantDTO);
        return convertToDto(enfantRepository.save(enfant));
    }

    public List<EnfantDTO> getAll() {
        return enfantRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public EnfantDTO getById(Long id) {
        return enfantRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public EnfantDTO update(EnfantDTO enfantDTO) {
        Enfant enfant = convertToEntity(enfantDTO);
        return convertToDto(enfantRepository.save(enfant));
    }

    public void delete(Long id) {
        enfantRepository.deleteById(id);
    }
}

