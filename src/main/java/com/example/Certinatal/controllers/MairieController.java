package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.MairieDTO;
import com.example.Certinatal.services.impl.MairieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class MairieController {

    @Autowired
    private MairieServiceImpl mairieService;

    @PostMapping("/mairie/save")
    public ResponseEntity<MairieDTO> save(@RequestBody MairieDTO mairieDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mairieService.save(mairieDTO));
    }

    @GetMapping("/mairie/all")
    public ResponseEntity<List<MairieDTO>> getAll() {
        return ResponseEntity.ok(mairieService.getAll());
    }

    @GetMapping("/mairie/{id}")
    public ResponseEntity<MairieDTO> getById(@PathVariable Long id) {
        MairieDTO mairieDTO = mairieService.getById(id);
        if (mairieDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mairieDTO);
    }

    @PutMapping("/mairie/update/{id}")
    public ResponseEntity<MairieDTO> update(@PathVariable Long id, @RequestBody MairieDTO mairieDTO) {
        MairieDTO existingMairie = mairieService.getById(id);
        if (existingMairie == null)
            return ResponseEntity.notFound().build();
        mairieDTO.setId(id);
        return ResponseEntity.ok(mairieService.update(mairieDTO));
    }

    @DeleteMapping("/mairie/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        MairieDTO mairieDTO = mairieService.getById(id);
        if (mairieDTO == null)
            return ResponseEntity.notFound().build();
        mairieService.delete(id);
        return ResponseEntity.ok().build();
    }
}

