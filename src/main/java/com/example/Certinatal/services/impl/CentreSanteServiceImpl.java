package com.example.Certinatal.services.impl;

import com.example.Certinatal.Enum.TypeRole;
import com.example.Certinatal.dto.CentreSanteDTO;
import com.example.Certinatal.models.CentreSante;
import com.example.Certinatal.models.Role;
import com.example.Certinatal.models.Utilisateur;
import com.example.Certinatal.repository.CentreSanteRepository;
import com.example.Certinatal.repository.UtilisateurRepository;
import com.example.Certinatal.services.CentreSanteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentreSanteServiceImpl implements CentreSanteService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CentreSanteRepository centreSanteRepository;
    @Autowired
    private UtilisateurRepository usersRepository;
    @Autowired
    private ValidationServiceImpl validationServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private CentreSanteDTO convertToDto(CentreSante centreSante) {
        return modelMapper.map(centreSante, CentreSanteDTO.class);
    }

    private CentreSante convertToEntity(CentreSanteDTO centreSanteDTO) {
        return modelMapper.map(centreSanteDTO, CentreSante.class);
    }

    // Méthode pour sauvegarder un CentreSante
    public CentreSanteDTO save(CentreSanteDTO centreSanteDTO) {
        CentreSante centreSante = convertToEntity(centreSanteDTO);
        CentreSante savedCentreSante = centreSanteRepository.save(centreSante);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(centreSante.getEmail());

        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(mdpCrypte);

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeRole.CENTRE_SANTE);
        utilisateur.setRole(roleUtilisateur);

        this.usersRepository.save(utilisateur);
        this.validationServiceImpl.enregistrer(utilisateur);
        return convertToDto(savedCentreSante);
    }

    // Méthode pour obtenir tous les centres de santé
    public List<CentreSanteDTO> getAll() {
        return centreSanteRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Méthode pour obtenir un CentreSante par son id
    public CentreSanteDTO getById(Long id) {
        return centreSanteRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    // Méthode pour mettre à jour un CentreSante existant
    public CentreSanteDTO update(CentreSanteDTO centreSanteDTO) {
        CentreSante centreSante = convertToEntity(centreSanteDTO);
        CentreSante updatedCentreSante = centreSanteRepository.save(centreSante);
        return convertToDto(updatedCentreSante);
    }

    // Méthode pour supprimer un CentreSante par son id
    public void delete(Long id) {
        centreSanteRepository.deleteById(id);
    }

}
