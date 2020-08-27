package beans;

import java.util.ArrayList;

public class Professeur extends Personne{
    private String adresse_mail;
    private ArrayList<Emprunt> listEmprunts;
    private ArrayList<Classe> listClasses;

    public Professeur(String adresse_mail) {
        super();
        this.adresse_mail = adresse_mail;
    }

    public Professeur(String adresse_mail, ArrayList<Emprunt> listEmprunts) {
        this.adresse_mail = adresse_mail;
        this.listEmprunts = listEmprunts;
    }

    public Professeur() {

    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public ArrayList<Emprunt> getListEmprunts() {
        return listEmprunts;
    }

    public void setListEmprunts(ArrayList<Emprunt> listEmprunts) {
        this.listEmprunts = listEmprunts;
    }

    public ArrayList<Classe> getListClasses() {
        return listClasses;
    }

    public void setListClasses(ArrayList<Classe> listClasses) {
        this.listClasses = listClasses;
    }

    public void evaluer(){

    }
}
