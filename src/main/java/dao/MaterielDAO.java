package dao;

import beans.Materiel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

public class MaterielDAO {
    static Connection conn;

    /**
     * Connexion à la BDD
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
     * Afficher tout le matériel
     * */
    public static ArrayList<Materiel> displayMateriel() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Materiel> materiels = new ArrayList<>();
        String query = "SELECT * FROM materiel";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Materiel materiel = new Materiel();

            int id = rs.getInt("id_materiel");
            String nom = rs.getString("materiel.nom");
            Date date_achat = rs.getDate("materiel.date_achat");

            materiel.setId_materiel(id);
            materiel.setNom(nom);
            materiel.setDate(date_achat);

            materiels.add(materiel);

            // print the result
            System.out.format("%s, %s\n", nom, date_achat);
        }
        conn.close();
        return materiels;
    }
    /**
     * Créer matériel
     * */
    public void creerMateriel(Materiel materiel) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println("creerMateriel");
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(format.format(date));

        preparedStatement = conn.prepareStatement("INSERT INTO materiel(nom, date_achat) VALUES(?, ?);");
        preparedStatement.setString(1, materiel.getNom());
        preparedStatement.setDate(2, date);

        preparedStatement.executeUpdate();
        System.out.println(materiel);

        conn.close();
    }
    /**
     * Supprimer un matériel
     * */
    public void supprimerMateriel(int id_materiel) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        System.out.println(id_materiel);
        // connexion = daoFactory.getConnection();
        preparedStatement = conn.prepareStatement("DELETE FROM materiel where id_materiel=?;");
        preparedStatement.setInt(1, id_materiel);
        preparedStatement.executeUpdate();
        conn.close();
    }
}