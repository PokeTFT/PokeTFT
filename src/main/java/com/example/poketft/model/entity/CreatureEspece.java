package com.example.poketft.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatureEspece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int basePv;

    private int baseAttaque;

    private int baseDefense;

    private int baseVitesse;

    private String rarete;

    private String spritePath;

    @ManyToMany
    @JoinTable(
            name = "espece_type",
            joinColumns = @JoinColumn(name = "espece_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<TypeCreature> types;
}
