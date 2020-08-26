package beans;

import java.util.Date;

public class Emprunt {
    private int id_emprunt;
    private Professeur professeur;
    private Bouquin bouquin;
    private Materiel materiel;
    private Date date_debut;
    private Date date_fin;

    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Bouquin getBouquin() {
        return bouquin;
    }

    public void setBouquin(Bouquin bouquin) {
        this.bouquin = bouquin;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
