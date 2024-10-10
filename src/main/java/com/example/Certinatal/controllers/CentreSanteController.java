package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.CentreSanteDTO;
import com.example.Certinatal.services.impl.CentreSanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CentreSanteController {

    @Autowired
    private CentreSanteServiceImpl centreSanteService;

    @PostMapping("/centreSante/save")
    public ResponseEntity<CentreSanteDTO> save(@RequestBody CentreSanteDTO centreSanteDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(centreSanteService.save(centreSanteDTO));
    }

    @GetMapping("/centreSante/all")
    public ResponseEntity<List<CentreSanteDTO>> getAll() {
        return ResponseEntity.ok(centreSanteService.getAll());
    }

    @GetMapping("/centreSante/{id}")
    public ResponseEntity<CentreSanteDTO> getById(@PathVariable Long id) {
        CentreSanteDTO centreSanteDTO = centreSanteService.getById(id);
        if (centreSanteDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(centreSanteDTO);
    }

    @PutMapping("/centreSante/update/{id}")
    public ResponseEntity<CentreSanteDTO> update(@PathVariable Long id, @RequestBody CentreSanteDTO centreSanteDTO) {
        CentreSanteDTO existingCentreSante = centreSanteService.getById(id);
        if (existingCentreSante == null)
            return ResponseEntity.notFound().build();
        centreSanteDTO.setId(id);
        return ResponseEntity.ok(centreSanteService.update(centreSanteDTO));
    }

    @DeleteMapping("/centreSante/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CentreSanteDTO centreSanteDTO = centreSanteService.getById(id);
        if (centreSanteDTO == null)
            return ResponseEntity.notFound().build();
        centreSanteService.delete(id);
        return ResponseEntity.ok().build();
    }
}

