package com.example.poketft.service;

import com.example.poketft.model.entity.Joueur;

import java.util.List;

public interface JoueurService {

    List<Joueur> findAll();

    Joueur findById(Long id);

    Joueur save(Joueur joueur);

    void deleteById(Long id);

    List<Joueur> searchByPseudo(String query);
}
