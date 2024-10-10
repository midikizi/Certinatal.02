package com.example.Certinatal.services;


import com.example.Certinatal.dto.PosteDTO;

import java.util.List;

public interface PosteService {
     PosteDTO save(PosteDTO posteDTO);
     List<PosteDTO> getAll();
     PosteDTO update(PosteDTO posteDTO);
     void delete(Long id);
     PosteDTO getById(Long id);
}