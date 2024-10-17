package com.example.Certinatal.services.impl;

import com.example.Certinatal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiquesService {

    @Autowired
    private EnfantRepository enfantRepository;

    @Autowired
    private CentreSanteRepository centreSanteRepository;

    @Autowired
    private MairieRepository mairieRepository;

    @Autowired
    private DeclarationNaissanceRepository declarationNaissanceRepository;

    public List<Object[]> getNaissancesParPrefecture(int mois, int annee) {
        return enfantRepository.findNaissancesParPrefecture(mois, annee);
    }

    public List<Object[]> getNaissancesParCentreSante(int mois, int annee) {
        return centreSanteRepository.findNaissancesParCentreSante(mois, annee);
    }

    public List<Object[]> getNaissancesParMairie(int mois, int annee) {
        return mairieRepository.findNaissancesParMairie(mois, annee);
    }

    public List<Object[]> getDeclarationsParMairie(int mois, int annee) {
        return declarationNaissanceRepository.findDeclarationsParMairie(mois, annee);
    }

//
    public List<Object[]> getNaissancesParPrefecture(int mois, int annee, String prefectureNom) {
        return enfantRepository.findNaissancesParPrefecture(mois, annee, prefectureNom);
    }

    public List<Object[]> getNaissancesParCentreSante(int mois, int annee, String centreSanteNom) {
        return centreSanteRepository.findNaissancesParCentreSante(mois, annee, centreSanteNom);
    }

    public List<Object[]> getDeclarationsParMairie(int mois, int annee, String mairieNom) {
        return declarationNaissanceRepository.findDeclarationsParMairie(mois, annee, mairieNom);
    }

    public List<Object[]> getNaissancesParMairie(int mois, int annee, String mairieNom) {
        return mairieRepository.findNaissancesParMairie(mois, annee, mairieNom);
    }
}

