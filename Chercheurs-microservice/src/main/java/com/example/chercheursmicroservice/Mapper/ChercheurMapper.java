package com.example.chercheursmicroservice.Mapper;

import com.example.chercheursmicroservice.ChercheursDTO.ChercheurRequestDTO;
import com.example.chercheursmicroservice.ChercheursDTO.ChercheurResponseDTO;
import com.example.chercheursmicroservice.Entities.Chercheur;
import org.springframework.stereotype.Component;

@Component
public class ChercheurMapper {

    public Chercheur toEntity(ChercheurRequestDTO dto) {
        Chercheur c = new Chercheur();
        c.setMatricule(dto.getMatricule());
        c.setNom(dto.getNom());
        c.setPrenom(dto.getPrenom());
        c.setEnseignantId(dto.getEnseignantId());
        return c;
    }

    public ChercheurResponseDTO toDTO(Chercheur c) {
        ChercheurResponseDTO dto = new ChercheurResponseDTO();
        dto.setId(c.getId());
        dto.setMatricule(c.getMatricule());
        dto.setNom(c.getNom());
        dto.setPrenom(c.getPrenom());
        dto.setEnseignantId(c.getEnseignantId());
        return dto;
    }
}