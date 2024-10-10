package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.PosteDTO;
import com.example.Certinatal.services.impl.PosteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class PosteController {

    @Autowired
    private PosteServiceImpl posteService;

    @PostMapping("/poste/save")
    public ResponseEntity<PosteDTO> save(@RequestBody PosteDTO posteDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(posteService.save(posteDTO));
    }

    @GetMapping("/poste/all")
    public ResponseEntity<List<PosteDTO>> getAll() {
        return ResponseEntity.ok(posteService.getAll());
    }

    @GetMapping("/poste/{id}")
    public ResponseEntity<PosteDTO> getById(@PathVariable Long id) {
        PosteDTO posteDTO = posteService.getById(id);
        if (posteDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(posteDTO);
    }

    @PutMapping("/poste/update/{id}")
    public ResponseEntity<PosteDTO> update(@PathVariable Long id, @RequestBody PosteDTO posteDTO) {
        PosteDTO existingPoste = posteService.getById(id);
        if (existingPoste == null)
            return ResponseEntity.notFound().build();
        posteDTO.setId(id);
        return ResponseEntity.ok(posteService.update(posteDTO));
    }

    @DeleteMapping("/poste/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        PosteDTO posteDTO = posteService.getById(id);
        if (posteDTO == null)
            return ResponseEntity.notFound().build();
        posteService.delete(id);
        return ResponseEntity.ok().build();
    }
}

