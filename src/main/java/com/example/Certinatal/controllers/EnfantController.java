package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.EnfantDTO;
import com.example.Certinatal.services.impl.EnfantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/enfant")
public class EnfantController {

    @Autowired
    private EnfantServiceImpl enfantService;

    @PostMapping("/save")
    public ResponseEntity<EnfantDTO> save(@RequestBody EnfantDTO enfantDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(enfantService.save(enfantDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnfantDTO>> getAll() {
        return ResponseEntity.ok(enfantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfantDTO> getById(@PathVariable Long id) {
        EnfantDTO enfantDTO = enfantService.getById(id);
        if (enfantDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(enfantDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EnfantDTO> update(@PathVariable Long id, @RequestBody EnfantDTO enfantDTO) {
        EnfantDTO existingEnfant = enfantService.getById(id);
        if (existingEnfant == null)
            return ResponseEntity.notFound().build();
        enfantDTO.setId(id);
        return ResponseEntity.ok(enfantService.update(enfantDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        EnfantDTO enfantDTO = enfantService.getById(id);
        if (enfantDTO == null)
            return ResponseEntity.notFound().build();
        enfantService.delete(id);
        return ResponseEntity.ok().build();
    }
}

