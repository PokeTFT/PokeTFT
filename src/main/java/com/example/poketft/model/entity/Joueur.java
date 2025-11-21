package com.example.poketft.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pseudo;

    private String email;

    private int elo;

    @OneToMany(mappedBy = "joueur")
    private java.util.List<Partie> parties;

}
