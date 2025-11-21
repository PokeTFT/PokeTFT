package com.example.poketft.service.impl;

import com.example.poketft.model.entity.Joueur;
import com.example.poketft.repository.JoueurRepository;
import com.example.poketft.service.JoueurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;

    public JoueurServiceImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Override
    public List<Joueur> findAll() {
        return joueurRepository.findAll();
    }

    @Override
    public Joueur findById(Long id) {
        return joueurRepository.findById(id).orElse(null);
    }

    @Override
    public Joueur save(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @Override
    public void deleteById(Long id) {
        joueurRepository.deleteById(id);
    }

    @Override
    public List<Joueur> searchByPseudo(String query) {
        if (query == null || query.isBlank()) {
            return joueurRepository.findAll();
        }
        return joueurRepository.findByPseudoContainingIgnoreCase(query);
    }
}
