package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.RegionDTO;
import com.example.Certinatal.models.Region;
import com.example.Certinatal.repository.RegionRepository;
import com.example.Certinatal.services.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ModelMapper modelMapper;

    private RegionDTO convertToDto(Region region) {
        return modelMapper.map(region, RegionDTO.class);
    }

    private Region convertToEntity(RegionDTO regionDTO) {
        return modelMapper.map(regionDTO, Region.class);
    }

    @Override
    public RegionDTO save(RegionDTO regionDTO) {
        Region region = convertToEntity(regionDTO);
        Region savedRegion = regionRepository.save(region);
        return convertToDto(savedRegion);
    }

    @Override
    public List<RegionDTO> getAll() {
        return regionRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RegionDTO getById(Long id) {
        return regionRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public RegionDTO update(RegionDTO regionDTO) {
        Region region = convertToEntity(regionDTO);
        Region updatedRegion = regionRepository.save(region);
        return convertToDto(updatedRegion);
    }

    @Override
    public void delete(Long id) {
        regionRepository.deleteById(id);
    }
}
