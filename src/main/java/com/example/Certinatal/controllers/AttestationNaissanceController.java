package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.AttestationNaissanceDTO;
import com.example.Certinatal.services.impl.AttestationNaissanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/attestation")
public class AttestationNaissanceController {

    @Autowired
    private AttestationNaissanceServiceImpl attestationNaissanceService;

    @PostMapping("/save")
    public ResponseEntity<AttestationNaissanceDTO> save(@RequestBody AttestationNaissanceDTO attestationNaissanceDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(attestationNaissanceService.save(attestationNaissanceDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AttestationNaissanceDTO>> getAll() {
        return ResponseEntity.ok(attestationNaissanceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttestationNaissanceDTO> getById(@PathVariable Long id) {
        AttestationNaissanceDTO attestationNaissanceDTO = attestationNaissanceService.getById(id);
        if (attestationNaissanceDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(attestationNaissanceDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AttestationNaissanceDTO> update(@PathVariable Long id, @RequestBody AttestationNaissanceDTO attestationNaissanceDTO) {
        AttestationNaissanceDTO existingAttestation = attestationNaissanceService.getById(id);
        if (existingAttestation == null)
            return ResponseEntity.notFound().build();
        attestationNaissanceDTO.setId(id);
        return ResponseEntity.ok(attestationNaissanceService.update(attestationNaissanceDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        AttestationNaissanceDTO attestationNaissanceDTO = attestationNaissanceService.getById(id);
        if (attestationNaissanceDTO == null)
            return ResponseEntity.notFound().build();
        attestationNaissanceService.delete(id);
        return ResponseEntity.ok().build();
    }
}

