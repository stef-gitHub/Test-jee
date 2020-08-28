package dao;

import beans.Eleve;
import beans.Personne;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class EleveDAO {

    static Connection conn;

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


    public static void addEleve(Eleve eleve) throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        // the mysql insert statement
        String query = " insert into personne (nom, prenom, adresse, code_postal, ville)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, eleve.getNom());
        preparedStmt.setString (2, eleve.getPrenom());
        preparedStmt.setString (3, eleve.getAdresse());
        preparedStmt.setInt (4, eleve.getCp());
        preparedStmt.setString (5, eleve.getVille());

        // execute the preparedstatement
        preparedStmt.execute();


        System.out.println(eleve.getNom() +" "+ eleve.getNom() + " a été ajouté ");

        //Display last id inserted
        String displayLastInserted = "SELECT * FROM personne WHERE id_personne = (SELECT MAX(id_personne) FROM personne)";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(displayLastInserted);


        while (rs.next())
        {

            Integer id_personne = rs.getInt("personne.id_personne");
            eleve.setId_personne(id_personne);

            // print the result
            System.out.format("%s\n", id_personne);
        }

        System.out.println(eleve.getId_personne());

        //Add eleve with last id inserted
        String query1 = " insert into eleve (nom_pere, nom_mere, id_personne)"
                + " values (?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(query1);
        preparedStatement.setString(1, eleve.getPere());
        preparedStatement.setString(2, eleve.getMere());
        preparedStatement.setInt(3, eleve.getId_personne());

        preparedStatement.execute();
        System.out.println(eleve.getMere());
        conn.close();
    }

    public static void deleteEleve(int id) throws SQLException, ClassNotFoundException{
        String query = "Delete FROM eleve where id_eleve = ? ";

        try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            System.out.println("id : " + id + " supprimé !");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateEleve(String nom, String prenom, String adresse, int cp, String ville, String nom_pere, String nom_mere, int id) throws SQLException, ClassNotFoundException{
        String query = "Update eleve set nom = ?, prenom = ?, adresse = ?, cp = ?, ville = ?, nom_pere = ?, nom_mere where id_eleve = ?";

        PreparedStatement preparedStmt = conn.prepareStatement(query);

        preparedStmt.setString(1, nom);
        preparedStmt.setString(2, prenom);
        preparedStmt.setString(3, adresse);
        preparedStmt.setInt (4, cp);
        preparedStmt.setString (5, ville);
        preparedStmt.setString (6, nom_pere);
        preparedStmt.setString (7, nom_mere);
        preparedStmt.setInt(8, id);
        preparedStmt.executeUpdate();

        System.out.println("id : " + id + " mis à jour !");


    }

    public static ArrayList<Personne> displayEleve() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Personne> listEleves = new ArrayList<>();
        String query = "SELECT personne.nom, personne.prenom, eleve.nom_pere, eleve.nom_mere FROM personne inner join eleve on personne.id_personne = eleve.id_personne";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next())
        {
            Eleve eleve = new Eleve();

            String nom = rs.getString("personne.nom");
            String prenom = rs.getString("personne.prenom");
            String nom_pere = rs.getString("eleve.nom_pere");
            String nom_mere = rs.getString("eleve.nom_mere");

            eleve.setNom(nom);
            eleve.setPrenom(prenom);
            eleve.setPere(nom_pere);
            eleve.setMere(nom_mere);

            listEleves.add(eleve);

            // print the result
            System.out.format("%s, %s, %s, %s\n", nom, prenom, nom_pere, nom_mere);
        }
        conn.close();
        return listEleves;


    }
}
