package beans;

import java.util.ArrayList;

public class Ecole {
    private int id_ecole;
    private String nom;
    private String ville;
    private String adresse;
    private ArrayList<Classe> listClasses;

    public Ecole(int id_ecole, String nom, String ville, String adresse, ArrayList<Classe> listClasses) {
        this.id_ecole = id_ecole;
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.listClasses = listClasses;
    }

    public Ecole(String nom, String ville, String adresse, ArrayList<Classe> listClasses) {
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.listClasses = listClasses;
    }

    public int getId_ecole() {
        return id_ecole;
    }

    public void setId_ecole(int id_ecole) {
        this.id_ecole = id_ecole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Classe> getListClasses() {
        return listClasses;
    }

    public void setListClasses(ArrayList<Classe> listClasses) {
        this.listClasses = listClasses;
    }
}
