package com.example.projetmicroservice.Mapper;

import com.example.projetmicroservice.DTO.ProjetRequestDTO;
import com.example.projetmicroservice.DTO.ProjetResponseDTO;
import com.example.projetmicroservice.Entities.Projet;
import org.springframework.stereotype.Component;

@Component
public class ProjetMapper {

    public Projet toEntity(ProjetRequestDTO dto){
        Projet p = new Projet();
        p.setTitre(dto.titre);
        p.setDescription(dto.description);
        p.setChercheurId(dto.chercheurId);
        return p;
    }

    public ProjetResponseDTO toDTO(Projet p){
        ProjetResponseDTO dto = new ProjetResponseDTO();
        dto.id = p.getId();
        dto.titre = p.getTitre();
        dto.description = p.getDescription();
        dto.chercheurId = p.getChercheurId();
        return dto;
    }
}
