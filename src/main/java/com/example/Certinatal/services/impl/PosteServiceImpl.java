package com.example.Certinatal.services.impl;

import com.example.Certinatal.Enum.TypeRole;
import com.example.Certinatal.dto.PosteDTO;
import com.example.Certinatal.models.Poste;
import com.example.Certinatal.models.Role;
import com.example.Certinatal.models.Utilisateur;
import com.example.Certinatal.repository.PosteRepository;
import com.example.Certinatal.repository.UtilisateurRepository;
import com.example.Certinatal.services.PosteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PosteServiceImpl implements PosteService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PosteRepository posteRepository;
    @Autowired
    private UtilisateurRepository usersRepository;
    @Autowired
    private ValidationServiceImpl validationServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private PosteDTO convertToDto(Poste poste) {
        return modelMapper.map(poste, PosteDTO.class);
    }

    private Poste convertToEntity(PosteDTO posteDTO) {
        return modelMapper.map(posteDTO, Poste.class);
    }

    // Méthode pour sauvegarder un Poste
    public PosteDTO save(PosteDTO posteDTO) {
        Poste poste = convertToEntity(posteDTO);
        Poste savedPoste = posteRepository.save(poste);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(poste.getEmail());

        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(mdpCrypte);

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeRole.POSTE);
        utilisateur.setRole(roleUtilisateur);

        this.usersRepository.save(utilisateur);
        this.validationServiceImpl.enregistrer(utilisateur);
        return convertToDto(savedPoste);
    }

    @Override
    public List<PosteDTO> getAll() {
        return posteRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PosteDTO getById(Long id) {
        return posteRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public PosteDTO update(PosteDTO posteDTO) {
        Poste poste = convertToEntity(posteDTO);
        Poste updatedPoste = posteRepository.save(poste);
        return convertToDto(updatedPoste);
    }

    @Override
    public void delete(Long id) {
        posteRepository.deleteById(id);
    }
}
