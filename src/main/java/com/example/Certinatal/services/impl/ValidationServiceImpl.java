package com.example.Certinatal.services.impl;

import java.time.Instant;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.Certinatal.models.Utilisateur;
import com.example.Certinatal.models.Validation;
import com.example.Certinatal.repository.ValidationRepository;

import lombok.AllArgsConstructor;
import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Service
public class ValidationServiceImpl {
    
    private ValidationRepository validationRepository;
    private NotificationServiceImpl notificationServiceImpl;

    public void enregistrer(Utilisateur users) {
        Validation validation = new Validation();
        validation.setUsers(users);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationServiceImpl.envoyer(validation);
    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }
}