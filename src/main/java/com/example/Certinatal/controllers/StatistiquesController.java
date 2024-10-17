package com.example.Certinatal.controllers;

import com.example.Certinatal.services.impl.StatistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistiques")
public class StatistiquesController {

    @Autowired
    private StatistiquesService statistiquesService;

    @GetMapping("/naissances/prefecture")
    public ResponseEntity<List<Object[]>> getNaissancesParPrefecture(@RequestParam int mois, @RequestParam int annee) {
        return ResponseEntity.ok(statistiquesService.getNaissancesParPrefecture(mois, annee));
    }

    @GetMapping("/naissances/centre-sante")
    public ResponseEntity<List<Object[]>> getNaissancesParCentreSante(@RequestParam int mois, @RequestParam int annee) {
        return ResponseEntity.ok(statistiquesService.getNaissancesParCentreSante(mois, annee));
    }

    @GetMapping("/naissances/mairie")
    public ResponseEntity<List<Object[]>> getNaissancesParMairie(@RequestParam int mois, @RequestParam int annee) {
        return ResponseEntity.ok(statistiquesService.getNaissancesParMairie(mois, annee));
    }

    @GetMapping("/declarations/mairie")
    public ResponseEntity<List<Object[]>> getDeclarationsParMairie(@RequestParam int mois, @RequestParam int annee) {
        return ResponseEntity.ok(statistiquesService.getDeclarationsParMairie(mois, annee));
    }

//
    @GetMapping("/naissances/parPrefecture")
    public ResponseEntity<List<Object[]>> getNaissancesParPrefecture(
            @RequestParam int mois, @RequestParam int annee,
            @RequestParam String prefectureNom) {
        List<Object[]> result = statistiquesService.getNaissancesParPrefecture(mois, annee, prefectureNom);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/naissances/parCentre-sante")
    public ResponseEntity<List<Object[]>> getNaissancesParCentreSante(
            @RequestParam int mois, @RequestParam int annee,
            @RequestParam String centreSanteNom) {
        List<Object[]> result = statistiquesService.getNaissancesParCentreSante(mois, annee, centreSanteNom);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/naissances/parMairie")
    public ResponseEntity<List<Object[]>> getNaissancesParMairie(
            @RequestParam int mois, @RequestParam int annee,
            @RequestParam String mairieNom) {
        List<Object[]> result = statistiquesService.getNaissancesParMairie(mois, annee, mairieNom);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/declarations/parMairie")
    public ResponseEntity<List<Object[]>> getDeclarationsParMairie(
            @RequestParam int mois, @RequestParam int annee,
            @RequestParam String mairieNom) {
        List<Object[]> result = statistiquesService.getDeclarationsParMairie(mois, annee, mairieNom);
        return ResponseEntity.ok(result);
    }
}

