package beans;

import java.util.Date;

public class Bouquin {
    private int id_bouquin;
    private String nom;
    private String auteur;
    private Date date;

    public Bouquin() {
    }

    public int getId_bouquin() {
        return id_bouquin;
    }

    public void setId_bouquin(int id_bouquin) {
        this.id_bouquin = id_bouquin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
