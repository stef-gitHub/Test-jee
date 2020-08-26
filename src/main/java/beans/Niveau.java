package beans;

import java.util.ArrayList;

public class Niveau {
    private int id_niveau;
    private String libelle;
    private ArrayList<Classe> listClasse;

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Classe> getListClasse() {
        return listClasse;
    }

    public void setListClasse(ArrayList<Classe> listClasse) {
        this.listClasse = listClasse;
    }
}
