package com.example.Certinatal.services.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Certinatal.models.Validation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificationServiceImpl {

    JavaMailSender javaMailSender;
    public void envoyer(Validation validation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@CertiNatal.tech");
        message.setTo(validation.getUsers().getEmail());
        message.setSubject("Votre code d'activation");

        String texte = String.format(
                "Bonjour %s, <br /> Votre code d'activation est %s; A bientôt",
                validation.getUsers().getNom(),
                validation.getCode()
                );
        message.setText(texte);

        javaMailSender.send(message);
    
    }
}
