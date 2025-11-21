package com.example.poketft.service.impl;

import com.example.poketft.model.entity.CreatureEspece;
import com.example.poketft.repository.CreatureEspeceRepository;
import com.example.poketft.service.CreatureEspeceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureEspeceServiceImpl implements CreatureEspeceService {

    private final CreatureEspeceRepository creatureEspeceRepository;

    public CreatureEspeceServiceImpl(CreatureEspeceRepository creatureEspeceRepository) {
        this.creatureEspeceRepository = creatureEspeceRepository;
    }

    @Override
    public List<CreatureEspece> findAll() {
        return creatureEspeceRepository.findAll();
    }

    @Override
    public CreatureEspece findById(Long id) {
        return creatureEspeceRepository.findById(id).orElse(null);
    }

    @Override
    public CreatureEspece save(CreatureEspece espece) {
        return creatureEspeceRepository.save(espece);
    }

    @Override
    public void deleteById(Long id) {
        creatureEspeceRepository.deleteById(id);
    }
}
