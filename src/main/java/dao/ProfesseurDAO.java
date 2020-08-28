package dao;

import beans.Classe;
import beans.Niveau;
import beans.Personne;
import beans.Professeur;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ProfesseurDAO {

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

    public static void addProfessor(Professeur professeur) throws SQLException, ClassNotFoundException, IOException {

        connexionDB();

        // the mysql insert statement
        String query = " insert into personne (nom, prenom, adresse, code_postal, ville)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, professeur.getNom());
        preparedStmt.setString (2, professeur.getPrenom());
        preparedStmt.setString (3, professeur.getAdresse());
        preparedStmt.setInt (4, professeur.getCp());
        preparedStmt.setString (5, professeur.getVille());

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(professeur.getNom() +" "+ professeur.getNom() + " a été ajouté ");
        //Display last id inserted
        String displayLastInserted = "SELECT * FROM personne WHERE id_personne = (SELECT MAX(id_personne) FROM personne)";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(displayLastInserted);


        while (rs.next())
        {

            Integer id_personne = rs.getInt("personne.id_personne");
            professeur.setId_personne(id_personne);

            // print the result
            System.out.format("%s\n", id_personne);
        }

        System.out.println(professeur.getId_personne());

        //Add eleve with last id inserted
        String query1 = " insert into professeur (mail, id_personne)"
                + " values (?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(query1);
        preparedStatement.setString(1, professeur.getAdresse_mail());
        preparedStatement.setInt(2, professeur.getId_personne());

        preparedStatement.execute();
        System.out.println(professeur.getAdresse_mail());
        conn.close();
    }



    public static void modifierProfesseur(Professeur p) throws SQLException, IOException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        connexionDB();
        // connexion = daoFactory.getConnection();
        preparedStatement = conn.prepareStatement("UPDATE professeur, personne SET personne.nom=?, personne.prenom=?, professeur.mail=?, personne.adresse=?, personne.code_postal=?, personne.ville=? where personne.id_personne=? AND professeur.id_personne=?;");
        preparedStatement.setString(1, p.getNom());
        preparedStatement.setString(2, p.getPrenom());
        preparedStatement.setString(3, p.getAdresse_mail());
        preparedStatement.setString(4, p.getAdresse());
        preparedStatement.setInt(5, p.getCp());
        preparedStatement.setString(6, p.getVille());
        preparedStatement.setInt(7, p.getId_personne());
        preparedStatement.setInt(8, p.getId_personne());
        preparedStatement.executeUpdate();
        conn.close();
    }

    public ArrayList<Professeur> afficherProfesseur() throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        ArrayList<Professeur> professeurs = new ArrayList<>();

        try {
            String query = "SELECT * FROM professeur inner join personne ON professeur.id_personne = personne.id_personne";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                Professeur prof = new Professeur();
                Personne personne = new Personne();

                String mail = rs.getString("professeur.mail");
                String nom = rs.getString("personne.nom");
                String prenom = rs.getString("personne.prenom");
                int id = rs.getInt("professeur.id_personne");

                prof.setNom(nom);
                prof.setPrenom(prenom);
                prof.setAdresse_mail(mail);
                prof.setId_personne(id);
                prof.setAdresse_mail(rs.getString("professeur.mail"));
                prof.setAdresse(rs.getString("personne.adresse"));
                prof.setCp(rs.getInt("personne.code_postal"));
                prof.setVille(rs.getString("personne.ville"));

                System.out.println(prof.getNom() + " " + prof.getPrenom() + " "+ prof.getAdresse_mail());

                professeurs.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();

        return professeurs;
    }

    public static void suppProf(int id) throws SQLException, IOException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        connexionDB();
        //System.out.println(id);
        // connexion = daoFactory.getConnection();
        preparedStatement = conn.prepareStatement("DELETE FROM personne where id_personne=?;");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
    }


    public static Professeur getProfFromId(int id) throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        Professeur prof = new Professeur();

        String query = "SELECT * FROM professeur, personne where personne.id_personne = professeur.id_personne and professeur.id_personne = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            prof.setNom(rs.getString("personne.nom"));
            prof.setPrenom(rs.getString("personne.prenom"));
            prof.setId_personne(rs.getInt("personne.id_personne"));
            prof.setAdresse_mail(rs.getString("professeur.mail"));
            prof.setAdresse(rs.getString("personne.adresse"));
            prof.setCp(rs.getInt("personne.code_postal"));
            prof.setVille(rs.getString("personne.ville"));

        }
        conn.close();

        return prof;
    }

}


