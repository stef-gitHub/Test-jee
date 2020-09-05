package dao;

import beans.Eleve;
import beans.Niveau;
import beans.Personne;
import beans.Professeur;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class EleveDAO {

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
     * Ajouter un élève
     * */
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

        conn.close();
    }
    /**
     * Supprimer un élève
     * */
    public static void deleteEleve(int id) throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        String query = "Delete FROM personne where id_personne = ? ";

        try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            System.out.println("id : " + id + " supprimé !");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.close();
    }

    /**
     * Modifier un élève
     */
    public static void updateEleve(Eleve eleve) throws SQLException, ClassNotFoundException, IOException {
        connexionDB();
        String query = "Update personne , eleve set personne.nom = ?, personne.prenom = ?, personne.adresse = ?," +
                " personne.code_postal = ?, personne.ville = ? , eleve.nom_pere = ?, eleve.nom_mere = ? where personne.id_personne = ? and eleve.id_personne = ?";

        PreparedStatement preparedStmt = conn.prepareStatement(query);

        preparedStmt.setString(1, eleve.getNom());
        preparedStmt.setString(2, eleve.getPrenom());
        preparedStmt.setString(3, eleve.getAdresse());
        preparedStmt.setInt (4, eleve.getCp());
        preparedStmt.setString (5, eleve.getVille());
        preparedStmt.setString (6, eleve.getPere());
        preparedStmt.setString (7, eleve.getMere());
        preparedStmt.setInt(8, eleve.getId_personne());
        preparedStmt.setInt(9, eleve.getId_personne());
        preparedStmt.executeUpdate();

        conn.close();

    }
    /**
     * Affichage des élèves
     * */
    public static ArrayList<Personne> displayEleve() throws SQLException, ClassNotFoundException, IOException {

        connexionDB();
        ArrayList<Personne> listEleves = new ArrayList<>();
        String query = "SELECT personne.id_personne, personne.nom, personne.prenom, eleve.nom_pere, eleve.nom_mere, personne.adresse, personne.code_postal, personne.ville FROM personne inner join eleve on personne.id_personne = eleve.id_personne";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            Eleve eleve = new Eleve();
            int id = rs.getInt("personne.id_personne");
            String nom = rs.getString("personne.nom");
            String prenom = rs.getString("personne.prenom");
            String nom_pere = rs.getString("eleve.nom_pere");
            String nom_mere = rs.getString("eleve.nom_mere");
            String adresse = rs.getString("personne.adresse");
            int cp = rs.getInt("personne.code_postal");
            String ville = rs.getString("personne.ville");

            eleve.setId_personne(id);
            eleve.setNom(nom);
            eleve.setPrenom(prenom);
            eleve.setPere(nom_pere);
            eleve.setMere(nom_mere);
            eleve.setAdresse(adresse);
            eleve.setCp(cp);
            eleve.setVille(ville);

            listEleves.add(eleve);

            // print the result
            System.out.format("%s, %s, %s, %s, %s\n", id, nom, prenom, nom_pere, nom_mere, adresse, cp, ville);
        }

        conn.close();

        return listEleves;
    }
    /**
     * récupération des infos personne pour les lier à élvève (héritage)
     * */
    public static Eleve getEleveFromId(int id) throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        Eleve eleve = new Eleve();

        String query = "SELECT * FROM eleve, personne where personne.id_personne = eleve.id_personne and eleve.id_personne = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            eleve.setNom(rs.getString("personne.nom"));
            eleve.setPrenom(rs.getString("personne.prenom"));
            eleve.setId_personne(rs.getInt("personne.id_personne"));
            eleve.setAdresse(rs.getString("personne.adresse"));
            eleve.setCp(rs.getInt("personne.code_postal"));
            eleve.setVille(rs.getString("personne.ville"));
            eleve.setPere(rs.getString("eleve.nom_pere"));
            eleve.setMere(rs.getString("eleve.nom_mere"));

        }
        conn.close();

        return eleve;
    }
}
