package com.example.poketft.repository;

import com.example.poketft.model.entity.CreatureInstance;
import com.example.poketft.model.entity.Partie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatureInstanceRepository extends JpaRepository<CreatureInstance, Long> {

    List<CreatureInstance> findByPartieAndPosXIsNullAndPosYIsNull(Partie partie);

    List<CreatureInstance> findByPartieAndPosXIsNotNullAndPosYIsNotNull(Partie partie);
}
