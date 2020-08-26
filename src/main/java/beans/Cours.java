package beans;

import java.util.ArrayList;
import java.util.Date;

public class Cours {
    private int id_cours;
    private Classe classe;
    private ArrayList<Personne> listPersonnes;
    private String nom;
    private Date date;
    private ArrayList<Note> listNotes;

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Personne> getListPersonnes() {
        return listPersonnes;
    }

    public void setListPersonnes(ArrayList<Personne> listPersonnes) {
        this.listPersonnes = listPersonnes;
    }

    public ArrayList<Note> getListNotes() {
        return listNotes;
    }

    public void setListNotes(ArrayList<Note> listNotes) {
        this.listNotes = listNotes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
