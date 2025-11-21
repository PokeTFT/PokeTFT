package com.example.poketft.service;

import com.example.poketft.model.entity.CreatureEspece;

import java.util.List;

public interface CreatureEspeceService {

    List<CreatureEspece> findAll();

    CreatureEspece findById(Long id);

    CreatureEspece save(CreatureEspece espece);

    void deleteById(Long id);
}
