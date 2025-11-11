package com.example.projetmicroservice.Service;


import com.example.projetmicroservice.DTO.ProjetRequestDTO;
import com.example.projetmicroservice.DTO.ProjetResponseDTO;
import com.example.projetmicroservice.Entities.Projet;
import com.example.projetmicroservice.Mapper.ProjetMapper;
import com.example.projetmicroservice.Repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    private final ProjetRepository repo;
    private final ProjetMapper mapper;

    public ProjetService(ProjetRepository repo, ProjetMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ProjetResponseDTO create(ProjetRequestDTO req){
        Projet p = mapper.toEntity(req);
        return mapper.toDTO(repo.save(p));
    }

    public List<ProjetResponseDTO> all(){
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public ProjetResponseDTO one(Integer id){
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public ProjetResponseDTO update(Integer id, ProjetRequestDTO req){
        return repo.findById(id).map(p -> {
            p.setTitre(req.titre);
            p.setDescription(req.description);
            p.setChercheurId(req.chercheurId);
            return mapper.toDTO(repo.save(p));
        }).orElse(null);
    }

    public boolean delete(Integer id){
        if(!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    public List<ProjetResponseDTO> byChercheur(Integer chercheurId){
        return repo.findByChercheurId(chercheurId).stream().map(mapper::toDTO).toList();
    }
}
