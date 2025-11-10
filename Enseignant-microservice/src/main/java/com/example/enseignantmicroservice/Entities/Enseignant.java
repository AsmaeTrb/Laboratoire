package com.example.enseignantmicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nom;

    @Column(nullable=false)
    private String prenom;

    @Column(nullable=false, length=50)
    private String cne;

    @Column(nullable=false, length=150)
    private String email;

    @Column(nullable=false)
    private String password;

    private String thematique;
    public Integer getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getCne() { return cne; }
    public void setCne(String cne) { this.cne = cne; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getThematique() { return thematique; }
    public void setThematique(String thematique) { this.thematique = thematique; }
}
