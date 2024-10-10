package com.example.Certinatal.services.impl;

import com.example.Certinatal.Enum.TypeRole;
import com.example.Certinatal.dto.MairieDTO;
import com.example.Certinatal.models.Mairie;
import com.example.Certinatal.models.Role;
import com.example.Certinatal.models.Utilisateur;
import com.example.Certinatal.repository.MairieRepository;
import com.example.Certinatal.repository.UtilisateurRepository;
import com.example.Certinatal.services.MairieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MairieServiceImpl implements MairieService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MairieRepository mairieRepository;
    @Autowired
    private UtilisateurRepository usersRepository;
    @Autowired
    private ValidationServiceImpl validationServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private MairieDTO convertToDto(Mairie mairie) {
        return modelMapper.map(mairie, MairieDTO.class);
    }

    private Mairie convertToEntity(MairieDTO mairieDTO) {
        return modelMapper.map(mairieDTO, Mairie.class);
    }

    // Méthode pour sauvegarder une Mairie
    public MairieDTO save(MairieDTO mairieDTO) {
        Mairie mairie = convertToEntity(mairieDTO);
        Mairie savedMairie = mairieRepository.save(mairie);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(mairie.getEmail());

        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(mdpCrypte);

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeRole.MAIRIE);
        utilisateur.setRole(roleUtilisateur);

        this.usersRepository.save(utilisateur);
        this.validationServiceImpl.enregistrer(utilisateur);
        return convertToDto(savedMairie);
    }

    // Méthode pour obtenir toutes les Mairies
    public List<MairieDTO> getAll() {
        return mairieRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Méthode pour obtenir une Mairie par son id
    public MairieDTO getById(Long id) {
        return mairieRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    // Méthode pour mettre à jour une Mairie existante
    public MairieDTO update(MairieDTO mairieDTO) {
        Mairie mairie = convertToEntity(mairieDTO);
        Mairie updatedMairie = mairieRepository.save(mairie);
        return convertToDto(updatedMairie);
    }

    // Méthode pour supprimer une Mairie par son id
    public void delete(Long id) {
        mairieRepository.deleteById(id);
    }
}

