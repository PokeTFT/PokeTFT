package com.example.poketft.repository;

import com.example.poketft.model.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    List<Joueur> findByPseudoContainingIgnoreCase(String pseudo);
}
