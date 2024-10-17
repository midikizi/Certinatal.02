package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.DeclarationNaissanceDTO;
import com.example.Certinatal.services.impl.DeclarationNaissanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/declaration-naissance")
public class DeclarationNaissanceController {

    @Autowired
    private DeclarationNaissanceServiceImpl declarationNaissanceService;

    // Enregistrer une nouvelle déclaration de naissance
    @PostMapping("/save")
    public ResponseEntity<DeclarationNaissanceDTO> save(@RequestBody DeclarationNaissanceDTO declarationNaissanceDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(declarationNaissanceService.save(declarationNaissanceDTO));
    }

    // Obtenir toutes les déclarations de naissance
    @GetMapping("/all")
    public ResponseEntity<List<DeclarationNaissanceDTO>> getAll() {
        return ResponseEntity.ok(declarationNaissanceService.getAll());
    }

    // Obtenir une déclaration de naissance par ID
    @GetMapping("/{id}")
    public ResponseEntity<DeclarationNaissanceDTO> getById(@PathVariable Long id) {
        DeclarationNaissanceDTO declarationNaissanceDTO = declarationNaissanceService.getById(id);
        if (declarationNaissanceDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(declarationNaissanceDTO);
    }

    // Mettre à jour une déclaration de naissance
    @PutMapping("/update/{id}")
    public ResponseEntity<DeclarationNaissanceDTO> update(@PathVariable Long id, @RequestBody DeclarationNaissanceDTO declarationNaissanceDTO) {
        DeclarationNaissanceDTO existingDeclaration = declarationNaissanceService.getById(id);
        if (existingDeclaration == null)
            return ResponseEntity.notFound().build();
        declarationNaissanceDTO.setId(id);
        return ResponseEntity.ok(declarationNaissanceService.update(declarationNaissanceDTO));
    }

    // Supprimer une déclaration de naissance
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        DeclarationNaissanceDTO declarationNaissanceDTO = declarationNaissanceService.getById(id);
        if (declarationNaissanceDTO == null)
            return ResponseEntity.notFound().build();
        declarationNaissanceService.delete(id);
        return ResponseEntity.ok().build();
    }
}

