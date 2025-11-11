package com.example.chercheursmicroservice.ChercheursDTO;

public class ChercheurResponseDTO {
    private Integer id;
    private String matricule;
    private String nom;
    private String prenom;
    private Integer enseignantId;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Integer getEnseignantId() { return enseignantId; }
    public void setEnseignantId(Integer enseignantId) { this.enseignantId = enseignantId; }
}