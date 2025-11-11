package com.example.chercheursmicroservice.Service;

import com.example.chercheursmicroservice.ChercheursDTO.ChercheurRequestDTO;
import com.example.chercheursmicroservice.ChercheursDTO.ChercheurResponseDTO;
import com.example.chercheursmicroservice.Entities.Chercheur;
import com.example.chercheursmicroservice.Mapper.ChercheurMapper;
import com.example.chercheursmicroservice.Repository.ChercheurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChercheurService {
    private final ChercheurRepository repo;
    private final ChercheurMapper mapper;

    public ChercheurService(ChercheurRepository repo, ChercheurMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ChercheurResponseDTO create(ChercheurRequestDTO req) {
        Chercheur c = mapper.toEntity(req);
        return mapper.toDTO(repo.save(c));
    }

    public List<ChercheurResponseDTO> all() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public ChercheurResponseDTO one(Integer id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public ChercheurResponseDTO update(Integer id, ChercheurRequestDTO req) {
        return repo.findById(id)
                .map(c -> {
                    // mapping manuel simple (pas de méthode update dans le mapper, comme tu préfères)
                    c.setMatricule(req.getMatricule());
                    c.setNom(req.getNom());
                    c.setPrenom(req.getPrenom());
                    c.setEnseignantId(req.getEnseignantId());
                    return mapper.toDTO(repo.save(c));
                })
                .orElse(null);
    }

    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    public List<ChercheurResponseDTO> byEnseignant(Integer enseignantId) {
        return repo.findByEnseignantId(enseignantId).stream().map(mapper::toDTO).toList();
    }
}
