package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.QuartierCommuneDTO;
import com.example.Certinatal.services.impl.QuartierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class QuartierCommuneController {

    @Autowired
    private QuartierServiceImpl quartierService;

    @PostMapping("/quartier/save")
    public ResponseEntity<QuartierCommuneDTO> save(@RequestBody QuartierCommuneDTO quartierDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(quartierService.save(quartierDTO));
    }

    @GetMapping("/quartier/all")
    public ResponseEntity<List<QuartierCommuneDTO>> getAll() {
        return ResponseEntity.ok(quartierService.getAll());
    }

    @GetMapping("/quartier/{id}")
    public ResponseEntity<QuartierCommuneDTO> getById(@PathVariable Long id) {
        QuartierCommuneDTO quartierDTO = quartierService.getById(id);
        if (quartierDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(quartierDTO);
    }

    @PutMapping("/quartier/update/{id}")
    public ResponseEntity<QuartierCommuneDTO> update(@PathVariable Long id, @RequestBody QuartierCommuneDTO quartierDTO) {
        QuartierCommuneDTO existingQuartier = quartierService.getById(id);
        if (existingQuartier == null)
            return ResponseEntity.notFound().build();
        quartierDTO.setId(id);
        return ResponseEntity.ok(quartierService.update(quartierDTO));
    }

    @DeleteMapping("/quartier/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        QuartierCommuneDTO quartierDTO = quartierService.getById(id);
        if (quartierDTO == null)
            return ResponseEntity.notFound().build();
        quartierService.delete(id);
        return ResponseEntity.ok().build();
    }
}

