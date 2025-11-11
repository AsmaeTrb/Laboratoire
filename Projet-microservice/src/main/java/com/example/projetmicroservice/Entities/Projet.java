package com.example.projetmicroservice.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="projets")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String titre;

    @Column(nullable=false, length=1000)
    private String description;

    @Column(nullable=false)
    private Integer chercheurId; // relation logique vers Chercheur

    public Integer getId() { return id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getChercheurId() { return chercheurId; }
    public void setChercheurId(Integer chercheurId) { this.chercheurId = chercheurId; }
}
