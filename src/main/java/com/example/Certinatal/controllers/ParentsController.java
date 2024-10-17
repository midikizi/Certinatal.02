package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.ParentsDTO;
import com.example.Certinatal.services.impl.ParentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/parents")
public class ParentsController {

    @Autowired
    private ParentsServiceImpl parentsService;

    @PostMapping("/save")
    public ResponseEntity<ParentsDTO> save(@RequestBody ParentsDTO parentsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(parentsService.save(parentsDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParentsDTO>> getAll() {
        return ResponseEntity.ok(parentsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentsDTO> getById(@PathVariable Long id) {
        ParentsDTO parentsDTO = parentsService.getById(id);
        if (parentsDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(parentsDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ParentsDTO> update(@PathVariable Long id, @RequestBody ParentsDTO parentsDTO) {
        ParentsDTO existingParents = parentsService.getById(id);
        if (existingParents == null)
            return ResponseEntity.notFound().build();
        parentsDTO.setId(id);
        return ResponseEntity.ok(parentsService.update(parentsDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ParentsDTO parentsDTO = parentsService.getById(id);
        if (parentsDTO == null)
            return ResponseEntity.notFound().build();
        parentsService.delete(id);
        return ResponseEntity.ok().build();
    }
}

