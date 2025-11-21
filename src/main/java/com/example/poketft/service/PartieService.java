package com.example.poketft.service;

import com.example.poketft.model.entity.Partie;

public interface PartieService {

    Partie demarrerNouvellePartiePourJoueur(Long joueurId);

    Partie findById(Long id);
}
