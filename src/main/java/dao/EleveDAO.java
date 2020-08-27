package dao;

import beans.Personne;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class EleveDAO {

    static Connection conn;

    public static Connection connexionDB() throws SQLException, ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("C:/Users/Meunier/IdeaProjects/projet_ecole/src/main/resources/config.properties");
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

    public static void addEleve(String nom, String prenom, String adresse, int cp, String ville, String nom_pere, String nom_mere) throws SQLException, ClassNotFoundException{

        // the mysql insert statement
        String query = " insert into professeur (nom, prenom, adresse, cp, ville, nom_pere, nom_mere)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, nom);
        preparedStmt.setString (2, prenom);
        preparedStmt.setString (3, adresse);
        preparedStmt.setInt (4, cp);
        preparedStmt.setString (5, ville);
        preparedStmt.setString (6, nom_pere);
        preparedStmt.setString (7, nom_mere);

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(nom +" "+ nom + " a été ajouté ");
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
        ArrayList<Personne> listPersonnes = new ArrayList<>();
        String query = "SELECT * FROM personne inner join eleve on personne.id_personne = eleve.id_personne";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next())
        {
            Personne personne = new Personne();
            int id = rs.getInt("id_personne");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");

            personne.setId_personne(id);
            personne.setNom(nom);
            personne.setPrenom(prenom);

            listPersonnes.add(personne);

            // print the result
            System.out.format("%s, %s, %s\n", id, nom, prenom);
        }


        return listPersonnes;

    }
}