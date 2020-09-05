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
     * Supprimer un emprunt un emprunt
     * */
    public static void deleteEmprunt (Emprunt emprunt)throws SQLException, ClassNotFoundException, IOException {
        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println("Supprimer un emprunt : ");

        int idProf = emprunt.getProfesseur().getId_professeur();
        int idLivre = emprunt.getBouquin().getId_bouquin();
        int idMateriel = emprunt.getMateriel().getId_materiel();

        preparedStatement = conn.prepareStatement("DELETE FROM emprunt WHERE id_professeur = ? AND id_livre = ? AND id_materiel = ?");
        preparedStatement.setInt(1, idProf);
        preparedStatement.setInt(2, idLivre);
        preparedStatement.setInt(3, idMateriel);

        preparedStatement.executeUpdate();
        conn.close();
    }
    /**
     * Créer un emprunt
     * */
    public static void addEmprunt(Emprunt emprunt) throws SQLException, ClassNotFoundException, IOException {

        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println("créer un emprunt : ");
        Date date = new Date(System.currentTimeMillis());

        preparedStatement = conn.prepareStatement("INSERT IGNORE INTO emprunt(id_professeur, id_livre, id_materiel, date_debut) VALUES(?, ?, ?, ?)");
        preparedStatement.setInt(1, emprunt.getProfesseur().getId_professeur());
        preparedStatement.setInt(2, emprunt.getBouquin().getId_bouquin());
        preparedStatement.setInt(3, emprunt.getMateriel().getId_materiel());
        preparedStatement.setDate(4, date);

        preparedStatement.execute();

        System.out.println(emprunt);

        conn.close();
    }
    /**
     * Sélectionner un professeur par l'id
     * */
    public static Professeur getProfFromId(int id) throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        Professeur prof = new Professeur();

        String query = "SELECT * FROM professeur where professeur.id_professeur = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            prof.setId_professeur(rs.getInt("professeur.id_professeur"));
        }
        conn.close();

        return prof;
    }

    /**
     * Sélectionner un livre par son id
     * */
    public static Bouquin getBouquinFromId(int id) throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        Bouquin bouquin = new Bouquin();

        String query = "SELECT * FROM livre where livre.id_livre = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            bouquin.setId_bouquin(rs.getInt("livre.id_livre"));

        }
        conn.close();

        return bouquin;
    }

    /**
     * Sélectionner un matériel par son id
     * */
    public static Materiel getMaterielFromId(int id) throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        Materiel materiel = new Materiel();

        String query = "SELECT * FROM materiel where materiel.id_materiel = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            materiel.setId_materiel(rs.getInt("materiel.id_materiel"));
        }
        conn.close();

        return materiel;
    }

    /**
     * Afficher les emprunts
     * */
    public static ArrayList<Emprunt> displayEmprunt() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Emprunt> listEmprunt = new ArrayList<>();
        String query = "SELECT * FROM emprunt " +
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
            int idProf = rs.getInt("professeur.id_professeur");
            int idLivre = rs.getInt("livre.id_livre");
            int idMateriel = rs.getInt("materiel.id_materiel");

            prof.setNom(nom_personne);
            prof.setPrenom(prenom_personne);
            prof.setId_professeur(idProf);

            bouquin.setId_bouquin(idLivre);
            bouquin.setNom(nom_livre);

            materiel.setId_materiel(idMateriel);
            materiel.setNom(nom_materiel);

            emprunt.setProfesseur(prof);
            emprunt.setBouquin(bouquin);
            emprunt.setMateriel(materiel);
            emprunt.setDate_debut(date_debut);
            emprunt.setDate_fin(date_fin);

            listEmprunt.add(emprunt);

        }
        conn.close();

        return listEmprunt;
    }
}

