package com.example.poketft.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roundActuel;

    private int orRestant;

    private int pointsDeVie;

    private String statut;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @ManyToOne
    private Joueur joueur;

    @OneToMany(mappedBy = "partie", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<CreatureInstance> creatures;

}
