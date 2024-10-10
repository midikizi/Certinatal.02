package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.VilleDTO;
import com.example.Certinatal.services.impl.VilleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class VilleController {

    @Autowired
    private VilleServiceImpl villeService;

    @PostMapping("/ville/save")
    public ResponseEntity<VilleDTO> save(@RequestBody VilleDTO villeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(villeService.save(villeDTO));
    }

    @GetMapping("/ville/all")
    public ResponseEntity<List<VilleDTO>> getAll() {
        return ResponseEntity.ok(villeService.getAll());
    }

    @GetMapping("/ville/{id}")
    public ResponseEntity<VilleDTO> getById(@PathVariable Long id) {
        VilleDTO villeDTO = villeService.getById(id);
        if (villeDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(villeDTO);
    }

    @PutMapping("/ville/update/{id}")
    public ResponseEntity<VilleDTO> update(@PathVariable Long id, @RequestBody VilleDTO villeDTO) {
        VilleDTO existingVille = villeService.getById(id);
        if (existingVille == null)
            return ResponseEntity.notFound().build();
        villeDTO.setId(id);
        return ResponseEntity.ok(villeService.update(villeDTO));
    }

    @DeleteMapping("/ville/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        VilleDTO villeDTO = villeService.getById(id);
        if (villeDTO == null)
            return ResponseEntity.notFound().build();
        villeService.delete(id);
        return ResponseEntity.ok().build();
    }
}

