package com.example.enseignantmicroservice.Repository;

import com.example.enseignantmicroservice.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository  extends JpaRepository<Enseignant, Integer> {
}
