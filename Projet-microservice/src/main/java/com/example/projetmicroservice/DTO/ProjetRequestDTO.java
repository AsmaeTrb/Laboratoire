package com.example.projetmicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjetRequestDTO {
    public String titre;
    public String description;
    public Integer chercheurId;
}