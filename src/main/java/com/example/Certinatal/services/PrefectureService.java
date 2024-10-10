package com.example.Certinatal.services;

import com.example.Certinatal.dto.PrefectureDTO;

import java.util.List;

public interface PrefectureService {
    PrefectureDTO save(PrefectureDTO prefectureDTO);
    List<PrefectureDTO> getAll();
    PrefectureDTO update(PrefectureDTO prefectureDTO);
    void delete(Long id);
    PrefectureDTO getById(Long id);
}
