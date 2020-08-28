package dao;

import beans.Bouquin;
import beans.Materiel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

public class BouquinDAO {
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

    public static ArrayList<Bouquin> displayLivre() throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        ArrayList<Bouquin> bouquins = new ArrayList<>();
        String query = "SELECT * FROM livre";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Bouquin bouquin = new Bouquin();

            String nom = rs.getString("livre.libelle");
            String auteur = rs.getString("livre.auteur");
            Date date = rs.getDate("livre.date");

            bouquin.setNom(nom);
            bouquin.setAuteur(auteur);
            bouquin.setDate(date);

            bouquins.add(bouquin);

            // print the result
            System.out.format("%s, %s\n", nom, auteur, date);
        }
        conn.close();
        return bouquins;
    }

    public void creerLivre(Bouquin bouquin) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println("creerLivre");
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(format.format(date));

        preparedStatement = conn.prepareStatement("INSERT INTO livre(libelle, auteur, date) VALUES(?, ?, ?);");
        preparedStatement.setString(1, bouquin.getNom());
        preparedStatement.setString(2, bouquin.getAuteur());
        preparedStatement.setDate(3, date);

        preparedStatement.executeUpdate();
        System.out.println(bouquin);

        conn.close();
    }

    public void supprimerLivre(int id_livre) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        System.out.println(id_livre);
        // connexion = daoFactory.getConnection();
        preparedStatement = conn.prepareStatement("DELETE FROM livre where id_livre=?;");
        preparedStatement.setInt(1, id_livre);
        preparedStatement.executeUpdate();
        conn.close();
    }
}