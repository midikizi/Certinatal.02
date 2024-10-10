package com.example.Certinatal.services.impl;

import com.example.Certinatal.dto.PrefectureDTO;
import com.example.Certinatal.models.Prefecture;
import com.example.Certinatal.repository.PrefectureRepository;
import com.example.Certinatal.services.PrefectureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrefectureServiceImpl implements PrefectureService {

    @Autowired
    private PrefectureRepository prefectureRepository;

    @Autowired
    private ModelMapper modelMapper;

    private PrefectureDTO convertToDto(Prefecture prefecture) {
        return modelMapper.map(prefecture, PrefectureDTO.class);
    }

    private Prefecture convertToEntity(PrefectureDTO prefectureDTO) {
        return modelMapper.map(prefectureDTO, Prefecture.class);
    }

    @Override
    public PrefectureDTO save(PrefectureDTO prefectureDTO) {
        Prefecture prefecture = convertToEntity(prefectureDTO);
        Prefecture savedPrefecture = prefectureRepository.save(prefecture);
        return convertToDto(savedPrefecture);
    }

    @Override
    public List<PrefectureDTO> getAll() {
        return prefectureRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PrefectureDTO getById(Long id) {
        return prefectureRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public PrefectureDTO update(PrefectureDTO prefectureDTO) {
        Prefecture prefecture = convertToEntity(prefectureDTO);
        Prefecture updatedPrefecture = prefectureRepository.save(prefecture);
        return convertToDto(updatedPrefecture);
    }

    @Override
    public void delete(Long id) {
        prefectureRepository.deleteById(id);
    }
}

