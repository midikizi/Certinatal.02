package com.example.Certinatal.controllers;

import com.example.Certinatal.dto.TypeCentreDTO;
import com.example.Certinatal.services.impl.TypeCentreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class TypeCentreController {

    @Autowired
    private TypeCentreServiceImpl typeCentreService;

    @PostMapping("/typecentre/save")
    public ResponseEntity<TypeCentreDTO> save(@RequestBody TypeCentreDTO typeCentreDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(typeCentreService.save(typeCentreDTO));
    }

    @GetMapping("/typecentre/all")
    public ResponseEntity<List<TypeCentreDTO>> getAll() {
        return ResponseEntity.ok(typeCentreService.getAll());
    }

    @GetMapping("/typecentre/{id}")
    public ResponseEntity<TypeCentreDTO> getById(@PathVariable Long id) {
        TypeCentreDTO typeCentreDTO = typeCentreService.getById(id);
        if (typeCentreDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(typeCentreDTO);
    }

    @PutMapping("/typecentre/update/{id}")
    public ResponseEntity<TypeCentreDTO> update(@PathVariable Long id, @RequestBody TypeCentreDTO typeCentreDTO) {
        TypeCentreDTO existingTypeCentre = typeCentreService.getById(id);
        if (existingTypeCentre == null)
            return ResponseEntity.notFound().build();
        typeCentreDTO.setId(id);
        return ResponseEntity.ok(typeCentreService.update(typeCentreDTO));
    }

    @DeleteMapping("/typecentre/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        TypeCentreDTO typeCentreDTO = typeCentreService.getById(id);
        if (typeCentreDTO == null)
            return ResponseEntity.notFound().build();
        typeCentreService.delete(id);
        return ResponseEntity.ok().build();
    }
}

