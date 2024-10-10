package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.RegionDTO;
import com.example.Certinatal.services.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class RegionController {

    @Autowired
    private RegionServiceImpl regionService;

    @PostMapping("/region/save")
    public ResponseEntity<RegionDTO> save(@RequestBody RegionDTO regionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(regionService.save(regionDTO));
    }

    @GetMapping("/region/all")
    public ResponseEntity<List<RegionDTO>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id) {
        RegionDTO regionDTO = regionService.getById(id);
        if (regionDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDTO);
    }

    @PutMapping("/region/update/{id}")
    public ResponseEntity<RegionDTO> update(@PathVariable Long id, @RequestBody RegionDTO regionDTO) {
        RegionDTO existingRegion = regionService.getById(id);
        if (existingRegion == null)
            return ResponseEntity.notFound().build();
        regionDTO.setId(id);
        return ResponseEntity.ok(regionService.update(regionDTO));
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        RegionDTO regionDTO = regionService.getById(id);
        if (regionDTO == null)
            return ResponseEntity.notFound().build();
        regionService.delete(id);
        return ResponseEntity.ok().build();
    }
}

