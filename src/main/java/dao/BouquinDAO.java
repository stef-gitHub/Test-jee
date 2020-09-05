package dao;

import beans.Bouquin;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

public class BouquinDAO {
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
     * Afficher les livres
     * */
    public static ArrayList<Bouquin> displayLivre() throws SQLException, ClassNotFoundException, IOException {

        connexionDB();
        ArrayList<Bouquin> bouquins = new ArrayList<>();
        String query = "SELECT * FROM livre";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            Bouquin bouquin = new Bouquin();

            int id_livre = rs.getInt("livre.id_livre");
            String nom = rs.getString("livre.libelle");
            String auteur = rs.getString("livre.auteur");
            Date date = rs.getDate("livre.date");

            bouquin.setId_bouquin(id_livre);
            bouquin.setNom(nom);
            bouquin.setAuteur(auteur);
            bouquin.setDate(date);

            bouquins.add(bouquin);

            // print the result
            System.out.format("%s,%s, %s, %s\n", id_livre, nom, auteur, date);
        }
        conn.close();

        return bouquins;
    }

    /**
     * Créer un livre
     * */
    public void creerLivre(Bouquin bouquin) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        preparedStatement = conn.prepareStatement("INSERT INTO livre(libelle, auteur, date) VALUES(?, ?, ?);");
        preparedStatement.setString(1, bouquin.getNom());
        preparedStatement.setString(2, bouquin.getAuteur());
        preparedStatement.setDate(3, date);

        preparedStatement.executeUpdate();
        System.out.println(bouquin);

        conn.close();
    }

    /**
     * Supprimer un livre
     * */
    public void supprimerLivre(int id_livre) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        preparedStatement = conn.prepareStatement("DELETE FROM livre where id_livre=?;");
        preparedStatement.setInt(1, id_livre);
        preparedStatement.executeUpdate();

        conn.close();
    }
}