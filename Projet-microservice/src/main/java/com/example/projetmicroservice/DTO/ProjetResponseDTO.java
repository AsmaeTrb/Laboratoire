package com.example.projetmicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjetResponseDTO {
    public Integer id;
    public String titre;
    public String description;
    public Integer chercheurId;
}