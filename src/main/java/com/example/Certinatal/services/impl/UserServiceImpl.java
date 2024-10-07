package com.example.Certinatal.services.impl;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

import com.example.Certinatal.Enum.TypeRole;
import com.example.Certinatal.controllers.UtilisateurController;
import com.example.Certinatal.models.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Certinatal.models.Utilisateur;
import com.example.Certinatal.models.Validation;
import com.example.Certinatal.repository.UtilisateurRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService{

    private UtilisateurRepository usersRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private ValidationServiceImpl validationServiceImpl;


    public void inscription(Utilisateur utilissateur){

        if(!utilissateur.getEmail().contains("@")) {
            throw  new RuntimeException("Votre mail invalide");
        }
        if(!utilissateur.getEmail().contains(".")) {
            throw  new RuntimeException("Votre mail invalide");
        }
        Optional<Utilisateur> optinalUser = this.usersRepository.findByEmail(utilissateur.getEmail());
        if(optinalUser.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }
        
        String mdpCrypte = this.passwordEncoder.encode(utilissateur.getPassword());
        utilissateur.setPassword(mdpCrypte);

//         Role roleUtilisateur = new Role();
//         roleUtilisateur.setLibelle(TypeRole.PERSONNEL_MEDICAL);
//         utilissateur.setRole(roleUtilisateur);

        utilissateur = this.usersRepository.save(utilissateur);
        this.validationServiceImpl.enregistrer(utilissateur);
    }


    public void activation(Map<String, String> activation) {
        Validation validation = this.validationServiceImpl.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        Utilisateur utilisateurActiver = this.usersRepository.findById(validation.getUsers().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        utilisateurActiver.setActif(true);
        this.usersRepository.save(utilisateurActiver);
    }


    @Override
    public Utilisateur loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.usersRepository
                .findByEmail(username)
                .orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
    }

}

