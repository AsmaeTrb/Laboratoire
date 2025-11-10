package com.example.enseignantmicroservice.EnseignantDTO;

import lombok.Data;

public class EnseignantResponseDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String cne;
    private String email;
    private String thematique;
    // SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }
    public Integer getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getCne() {
        return cne;
    }
    public String getEmail() {
        return email;
    }
    public String getThematique() {
        return thematique;
    }

}
