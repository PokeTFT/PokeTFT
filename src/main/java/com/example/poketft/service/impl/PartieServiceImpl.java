package com.example.poketft.service.impl;

import com.example.poketft.model.entity.Joueur;
import com.example.poketft.model.entity.Partie;
import com.example.poketft.repository.JoueurRepository;
import com.example.poketft.repository.PartieRepository;
import com.example.poketft.service.PartieService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PartieServiceImpl implements PartieService {

    private final PartieRepository partieRepository;
    private final JoueurRepository joueurRepository;

    public PartieServiceImpl(PartieRepository partieRepository, JoueurRepository joueurRepository) {
        this.partieRepository = partieRepository;
        this.joueurRepository = joueurRepository;
    }

    @Override
    public Partie demarrerNouvellePartiePourJoueur(Long joueurId) {
        Joueur joueur = joueurRepository.findById(joueurId).orElse(null);
        if (joueur == null) {
            return null;
        }

        Partie partie = Partie.builder()
                .joueur(joueur)
                .roundActuel(1)
                .orRestant(10)
                .pointsDeVie(100)
                .statut("EN_COURS")
                .dateDebut(LocalDateTime.now())
                .build();

        return partieRepository.save(partie);
    }

    @Override
    public Partie findById(Long id) {
        return partieRepository.findById(id).orElse(null);
    }
}
