package com.example.enseignantmicroservice.Mapper;

import com.example.enseignantmicroservice.EnseignantDTO.EnseignantRequestDTO;
import com.example.enseignantmicroservice.EnseignantDTO.EnseignantResponseDTO;
import com.example.enseignantmicroservice.Entities.Enseignant;
import org.springframework.stereotype.Component;

@Component
public class EnseignantMapper {

    public Enseignant toEntity(EnseignantRequestDTO dto){
        Enseignant e = new Enseignant();
        e.setNom(dto.getNom());
        e.setPrenom(dto.getPrenom());
        e.setCne(dto.getCne());
        e.setEmail(dto.getEmail());
        e.setPassword(dto.getPassword());
        e.setThematique(dto.getThematique());
        return e;
    }

    public EnseignantResponseDTO toDTO(Enseignant e){
        EnseignantResponseDTO dto = new EnseignantResponseDTO();
        dto.setId(e.getId());
        dto.setNom(e.getNom());
        dto.setPrenom(e.getPrenom());
        dto.setCne(e.getCne());
        dto.setEmail(e.getEmail());
        dto.setThematique(e.getThematique());
        return dto;
    }
}
