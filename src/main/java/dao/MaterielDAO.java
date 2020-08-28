package dao;

import beans.Materiel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MaterielDAO {
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

    public static ArrayList<Materiel> displayMateriel() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Materiel> materiels = new ArrayList<>();
        String query = "SELECT * FROM materiel";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Materiel materiel = new Materiel();

            String nom = rs.getString("materiel.nom");
            Date date_achat = rs.getDate("materiel.date_achat");

            materiel.setNom(nom);
            materiel.setDate(date_achat);

            materiels.add(materiel);

            // print the result
            System.out.format("%s, %s\n", nom, date_achat);
        }
        conn.close();
        return materiels;
    }
}
