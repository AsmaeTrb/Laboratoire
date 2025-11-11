package com.example.chercheursmicroservice.Entities;

import jakarta.persistence.*;

@Entity
 public class Chercheur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String matricule;
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private Integer enseignantId;

    public Integer getId() { return id; }
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Integer getEnseignantId() { return enseignantId; }
    public void setEnseignantId(Integer enseignantId) { this.enseignantId = enseignantId; }
}