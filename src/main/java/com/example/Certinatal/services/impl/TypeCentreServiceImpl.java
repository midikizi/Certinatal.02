package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.TypeCentreDTO;
import com.example.Certinatal.models.TypeCentre;
import com.example.Certinatal.repository.TypeCentreRepository;
import com.example.Certinatal.services.TypeCentreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeCentreServiceImpl implements TypeCentreService {

    @Autowired
    private TypeCentreRepository typeCentreRepository;

    @Autowired
    private ModelMapper modelMapper;

    private TypeCentreDTO convertToDto(TypeCentre typeCentre) {
        return modelMapper.map(typeCentre, TypeCentreDTO.class);
    }

    private TypeCentre convertToEntity(TypeCentreDTO typeCentreDTO) {
        return modelMapper.map(typeCentreDTO, TypeCentre.class);
    }

    @Override
    public TypeCentreDTO save(TypeCentreDTO typeCentreDTO) {
        TypeCentre typeCentre = convertToEntity(typeCentreDTO);
        TypeCentre savedTypeCentre = typeCentreRepository.save(typeCentre);
        return convertToDto(savedTypeCentre);
    }

    @Override
    public List<TypeCentreDTO> getAll() {
        return typeCentreRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeCentreDTO getById(Long id) {
        return typeCentreRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public TypeCentreDTO update(TypeCentreDTO typeCentreDTO) {
        TypeCentre typeCentre = convertToEntity(typeCentreDTO);
        TypeCentre updatedTypeCentre = typeCentreRepository.save(typeCentre);
        return convertToDto(updatedTypeCentre);
    }

    @Override
    public void delete(Long id) {
        typeCentreRepository.deleteById(id);
    }
}

