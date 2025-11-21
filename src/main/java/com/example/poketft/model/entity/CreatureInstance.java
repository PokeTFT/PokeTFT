package com.example.poketft.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatureInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int niveau;

    private int pv;

    private int attaque;

    private int defense;

    private int vitesse;

    private Integer posX;

    private Integer posY;

    @ManyToOne
    private CreatureEspece espece;

    @ManyToOne
    private Partie partie;
}
