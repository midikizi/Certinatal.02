package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.QuartierCommuneDTO;
import com.example.Certinatal.models.QuartierCommune;
import com.example.Certinatal.repository.QuartierCommuneRepository;
import com.example.Certinatal.services.QuartierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartierServiceImpl implements QuartierService {

    @Autowired
    private QuartierCommuneRepository quartierRepository;

    @Autowired
    private ModelMapper modelMapper;

    private QuartierCommuneDTO convertToDto(QuartierCommune quartier) {
        return modelMapper.map(quartier, QuartierCommuneDTO.class);
    }

    private QuartierCommune convertToEntity(QuartierCommuneDTO quartierDTO) {
        return modelMapper.map(quartierDTO, QuartierCommune.class);
    }

    @Override
    public QuartierCommuneDTO save(QuartierCommuneDTO quartierDTO) {
        QuartierCommune quartier = convertToEntity(quartierDTO);
        QuartierCommune savedQuartier = quartierRepository.save(quartier);
        return convertToDto(savedQuartier);
    }

    @Override
    public List<QuartierCommuneDTO> getAll() {
        return quartierRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuartierCommuneDTO getById(Long id) {
        return quartierRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public QuartierCommuneDTO update(QuartierCommuneDTO quartierDTO) {
        QuartierCommune quartier = convertToEntity(quartierDTO);
        QuartierCommune updatedQuartier = quartierRepository.save(quartier);
        return convertToDto(updatedQuartier);
    }

    @Override
    public void delete(Long id) {
        quartierRepository.deleteById(id);
    }
}

