package dao;

import beans.Personne;
import beans.Professeur;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ProfesseurDAO {

    static Connection conn;
    /**
     * Connection à la BDD, /!\ vérifier le fichier config.properties /!\
     * */
    public static void connexionDB() throws SQLException, ClassNotFoundException, IOException {
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
    }

    /**
     * Créer un professeur
     * */
    public void creerProfesseur(Professeur professeur) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        try {
            // connexion = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO professeur(nom, annee, niveau) VALUES(?, ?, ?);");
            preparedStatement.setString(1, professeur.getNom());
            preparedStatement.setString(2, professeur.getPrenom());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
    }
    /**
     * Modifier un professeur
     * */
    public void modifierProfesseur(){

    }

    public ArrayList<Professeur> afficherProfesseur() throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        ArrayList<Professeur> professeurs = new ArrayList<>();

        try {
            String query = "SELECT professeur.mail, personne.nom, personne.prenom  FROM professeur inner join personne ON professeur.id_personne = personne.id_personne";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                Professeur prof = new Professeur();
                Personne personne = new Personne();

                String mail = rs.getString("professeur.mail");
                String nom = rs.getString("personne.nom");
                String prenom = rs.getString("personne.prenom");

                prof.setNom(nom);
                prof.setPrenom(prenom);
                prof.setAdresse_mail(mail);

                System.out.println(prof.getNom() + " " + prof.getPrenom() + " "+ prof.getAdresse_mail());

                professeurs.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();

        return professeurs;
    }
    /**
     * Supprimer un professeur
     * */
    public void supprimerProfesseur(){
    }
}


