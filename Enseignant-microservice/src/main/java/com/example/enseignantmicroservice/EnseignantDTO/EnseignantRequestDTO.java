package com.example.enseignantmicroservice.EnseignantDTO;

import lombok.Data;

public class EnseignantRequestDTO {
    private String nom;
    private String prenom;
    private String cne;
    private String email;
    private String password;
    private String thematique;
    // GETTERS
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

    public String getPassword() {
        return password;
    }

    public String getThematique() {
        return thematique;
    }

    // SETTERS
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }
}
