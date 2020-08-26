package beans;

import java.util.Date;

public class Presence {
    private int id_presence;
    private Cours cours;
    private Eleve eleve;
    private Professeur professeur;
    private Date date;

    public int getId_presence() {
        return id_presence;
    }

    public void setId_presence(int id_presence) {
        this.id_presence = id_presence;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
