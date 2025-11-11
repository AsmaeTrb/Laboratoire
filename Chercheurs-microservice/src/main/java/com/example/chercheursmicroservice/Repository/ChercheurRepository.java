package com.example.chercheursmicroservice.Repository;

import com.example.chercheursmicroservice.Entities.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChercheurRepository extends JpaRepository<Chercheur, Integer> {
    // utile pour l’agrégation côté Enseignant-service
    List<Chercheur> findByEnseignantId(Integer enseignantId);
}