package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.PrefectureDTO;
import com.example.Certinatal.services.impl.PrefectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class PrefectureController {

    @Autowired
    private PrefectureServiceImpl prefectureService;

    @PostMapping("/prefecture/save")
    public ResponseEntity<PrefectureDTO> save(@RequestBody PrefectureDTO prefectureDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(prefectureService.save(prefectureDTO));
    }

    @GetMapping("/prefecture/all")
    public ResponseEntity<List<PrefectureDTO>> getAll() {
        return ResponseEntity.ok(prefectureService.getAll());
    }

    @GetMapping("/prefecture/{id}")
    public ResponseEntity<PrefectureDTO> getById(@PathVariable Long id) {
        PrefectureDTO prefectureDTO = prefectureService.getById(id);
        if (prefectureDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(prefectureDTO);
    }

    @PutMapping("/prefecture/update/{id}")
    public ResponseEntity<PrefectureDTO> update(@PathVariable Long id, @RequestBody PrefectureDTO prefectureDTO) {
        PrefectureDTO existingPrefecture = prefectureService.getById(id);
        if (existingPrefecture == null)
            return ResponseEntity.notFound().build();
        prefectureDTO.setId(id);
        return ResponseEntity.ok(prefectureService.update(prefectureDTO));
    }

    @DeleteMapping("/prefecture/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        PrefectureDTO prefectureDTO = prefectureService.getById(id);
        if (prefectureDTO == null)
            return ResponseEntity.notFound().build();
        prefectureService.delete(id);
        return ResponseEntity.ok().build();
    }
}

