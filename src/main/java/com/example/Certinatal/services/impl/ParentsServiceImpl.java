package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.ParentsDTO;
import com.example.Certinatal.models.Parents;
import com.example.Certinatal.repository.ParentsRepository;
import com.example.Certinatal.services.ParentsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentsServiceImpl implements ParentsService {

    @Autowired
    private ParentsRepository parentsRepository;
    @Autowired
    private ModelMapper modelMapper;

    private ParentsDTO convertToDto(Parents parents) {
        return modelMapper.map(parents, ParentsDTO.class);
    }

    private Parents convertToEntity(ParentsDTO parentsDTO) {
        return modelMapper.map(parentsDTO, Parents.class);
    }

    public ParentsDTO save(ParentsDTO parentsDTO) {
        Parents parents = convertToEntity(parentsDTO);
        return convertToDto(parentsRepository.save(parents));
    }

    public List<ParentsDTO> getAll() {
        return parentsRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ParentsDTO getById(Long id) {
        return parentsRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public ParentsDTO update(ParentsDTO parentsDTO) {
        Parents parents = convertToEntity(parentsDTO);
        return convertToDto(parentsRepository.save(parents));
    }

    public void delete(Long id) {
        parentsRepository.deleteById(id);
    }
}

