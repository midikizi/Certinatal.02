package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.VilleDTO;
import com.example.Certinatal.models.Ville;
import com.example.Certinatal.repository.VilleRepository;
import com.example.Certinatal.services.VilleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VilleServiceImpl implements VilleService {

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private VilleDTO convertToDto(Ville ville) {
        return modelMapper.map(ville, VilleDTO.class);
    }

    private Ville convertToEntity(VilleDTO villeDTO) {
        return modelMapper.map(villeDTO, Ville.class);
    }

    @Override
    public VilleDTO save(VilleDTO villeDTO) {
        Ville ville = convertToEntity(villeDTO);
        Ville savedVille = villeRepository.save(ville);
        return convertToDto(savedVille);
    }

    @Override
    public List<VilleDTO> getAll() {
        return villeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VilleDTO getById(Long id) {
        return villeRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public VilleDTO update(VilleDTO villeDTO) {
        Ville ville = convertToEntity(villeDTO);
        Ville updatedVille = villeRepository.save(ville);
        return convertToDto(updatedVille);
    }

    @Override
    public void delete(Long id) {
        villeRepository.deleteById(id);
    }
}

