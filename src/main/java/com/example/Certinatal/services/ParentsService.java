package com.example.Certinatal.services;

import com.example.Certinatal.dto.ParentsDTO;

import java.util.List;

public interface ParentsService {
    ParentsDTO save(ParentsDTO parentsDTO);
    List<ParentsDTO> getAll();
    ParentsDTO update(ParentsDTO parentsDTO);
    void delete(Long id);
    ParentsDTO getById(Long id);
}
