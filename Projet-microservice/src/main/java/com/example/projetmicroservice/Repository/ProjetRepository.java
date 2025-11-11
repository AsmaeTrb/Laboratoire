package com.example.projetmicroservice.Repository;

import com.example.projetmicroservice.Entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    List<Projet> findByChercheurId(Integer chercheurId);
}