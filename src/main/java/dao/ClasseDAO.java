package dao;

import beans.Classe;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ClasseDAO {

    static Connection conn;

    public static void connexionDB() throws SQLException, ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("C:/Users/stef4/IdeaProjects/jee-project/src/main/resources/config.properties");
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
    public void creerClasse(Classe classe) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();

        try {
            // connexion = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO classe(nom, annee, niveau) VALUES(?, ?, ?);");
            preparedStatement.setString(1, classe.getNom());
            preparedStatement.setInt(2, classe.getAnnee());
            preparedStatement.setInt(3, classe.getId_niveau());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
    }

    public void modifierClasse(){
    }

    public ArrayList<Classe> afficherClasse() throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        ArrayList<Classe> classes = new ArrayList<>();

        try {
            String query = "SELECT * FROM classe";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                Classe classe = new Classe();
                String nom = rs.getString("classe.nom");

                System.out.println(nom);

                classe.setNom(nom);
                classes.add(classe);
            }
            System.out.println(classes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();

        return classes;
    }

    public void supprimerClasse(){
    }
}
