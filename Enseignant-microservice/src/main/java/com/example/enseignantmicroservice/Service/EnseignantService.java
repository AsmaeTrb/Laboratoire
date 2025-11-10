package com.example.enseignantmicroservice.Service;

import com.example.enseignantmicroservice.EnseignantDTO.EnseignantRequestDTO;
import com.example.enseignantmicroservice.EnseignantDTO.EnseignantResponseDTO;
import com.example.enseignantmicroservice.Entities.Enseignant;
import com.example.enseignantmicroservice.Mapper.EnseignantMapper;
import com.example.enseignantmicroservice.Repository.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {
    private final EnseignantRepository repo;
    private final EnseignantMapper mapper;

    public EnseignantService(EnseignantRepository repo, EnseignantMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public EnseignantResponseDTO create(EnseignantRequestDTO req) {
        // Utilisation du mapper pour convertir DTO → Entity
        Enseignant enseignant = mapper.toEntity(req);

        // Sauvegarder
        Enseignant saved = repo.save(enseignant);

        // Utilisation du mapper pour convertir Entity → ResponseDTO
        return mapper.toDTO(saved);
    }

    public List<EnseignantResponseDTO> all() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public EnseignantResponseDTO one(Integer id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public EnseignantResponseDTO update(Integer id, EnseignantRequestDTO req) {
        return repo.findById(id)
                .map(e -> {
                    // 🔥 Ici on met à jour à la main (puisque ton mapper ne fait que créer)
                    e.setNom(req.getNom());
                    e.setPrenom(req.getPrenom());
                    e.setCne(req.getCne());
                    e.setEmail(req.getEmail());
                    e.setPassword(req.getPassword());
                    e.setThematique(req.getThematique());
                    return mapper.toDTO(repo.save(e));
                })
                .orElse(null);
    }
    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
