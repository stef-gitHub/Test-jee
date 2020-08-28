package dao;

import beans.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class EmpruntDAO {

    static Connection conn;
    /**
     * Connection à la BDD, /!\ vérifier le fichier config.properties /!\
     * */
    public static Connection connexionDB() throws SQLException, ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
        Properties p = new Properties();
        p.load(fis);
        String dname = (String) p.get("Dname");
        String url = (String) p.get("URL");
        String user = (String) p.get("Uname");
        String passwd = (String) p.get("password");
        Class.forName(dname);
        conn = DriverManager.getConnection(url, user, passwd);

        System.out.println("Connexion réussie !");

        return conn;
    }
    /**
     * Créer un élève
     * */
    public static void addEmprunt() throws SQLException, ClassNotFoundException {
    }

    /**
     * Supprimer un élève
     * */
    public static void deleteEmprunt(int id) throws SQLException, ClassNotFoundException{
    }

    /**
     * Modifier un élève
     * */
    public static void updateEmprunt() throws SQLException, ClassNotFoundException{
    }

    /**
     * Afficher les élèves
     * */
    public static ArrayList<Emprunt> displayEmprunt() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Emprunt> listEmprunt = new ArrayList<>();
        String query = "SELECT emprunt.date_debut, emprunt.date_fin, materiel.nom, livre.libelle, personne.nom, personne.prenom FROM emprunt " +
                "INNER JOIN livre ON livre.id_livre = emprunt.id_livre "+
                "INNER JOIN materiel ON materiel.id_materiel = emprunt.id_materiel "+
                "INNER JOIN professeur ON professeur.id_professeur = emprunt.id_professeur "+
                "INNER JOIN personne ON personne.id_personne = professeur.id_personne";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            Emprunt emprunt = new Emprunt();
            Professeur prof = new Professeur();
            Bouquin bouquin = new Bouquin();
            Materiel materiel = new Materiel();

            String nom_personne = rs.getString("personne.nom");
            String prenom_personne = rs.getString("personne.prenom");
            String nom_livre= rs.getString("livre.libelle");
            String nom_materiel = rs.getString("materiel.nom");
            Date date_debut = rs.getDate("emprunt.date_debut");
            Date date_fin = rs.getDate("emprunt.date_fin");

            prof.setNom(nom_personne);
            prof.setPrenom(prenom_personne);
            bouquin.setNom(nom_livre);
            materiel.setNom(nom_materiel);

            emprunt.setProfesseur(prof);
            emprunt.setBouquin(bouquin);
            emprunt.setMateriel(materiel);
            emprunt.setDate_debut(date_debut);
            emprunt.setDate_fin(date_fin);

            listEmprunt.add(emprunt);

            // print the result
            System.out.format(" %s, %s, %s, %s, %s, %s\n", prenom_personne, nom_personne, nom_livre, nom_materiel, date_debut, date_fin);
        }

        return listEmprunt;
    }
}

