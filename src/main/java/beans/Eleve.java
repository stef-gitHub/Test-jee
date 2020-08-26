package beans;

import java.util.ArrayList;

public class Eleve {
    private String pere;
    private String mere;
    private String contact;
    private ArrayList<Note> listNotes;
    private Classe classe;

    public Eleve(String pere, String mere, String contact, Classe classe) {
        super();
        this.pere = pere;
        this.mere = mere;
        this.contact = contact;
        this.classe = classe;
    }

    public String getPere() {
        return pere;
    }

    public void setPere(String pere) {
        this.pere = pere;
    }

    public String getMere() {
        return mere;
    }

    public void setMere(String mere) {
        this.mere = mere;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<Note> getListNotes() {
        return listNotes;
    }

    public void setListNotes(ArrayList<Note> listNotes) {
        this.listNotes = listNotes;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
