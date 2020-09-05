package dao;

import beans.Classe;
import beans.Niveau;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ClasseDAO {

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

        //System.out.println("Connexion réussie !");
    }
    /**
     * Créer une classe
     * */
    public void creerClasse(Classe classe) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println("creerClasse");

        preparedStatement = conn.prepareStatement("INSERT INTO classe(nom, annee, id_niveau) VALUES(?, ?, ?);");
        preparedStatement.setString(1, classe.getNom());
        preparedStatement.setInt(2, classe.getAnnee());
        preparedStatement.setInt(3, classe.getNiveau().getId_niveau());

        preparedStatement.executeUpdate();
        System.out.println(classe);

        conn.close();
    }
    /**
     * Modifier une classe
     * */
    public void modifierClasse(Classe c) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        connexionDB();
        preparedStatement = conn.prepareStatement("UPDATE classe SET nom=?, annee=?, id_niveau=? where id_classe=?;");
        preparedStatement.setString(1, c.getNom());
        preparedStatement.setInt(2, c.getAnnee());
        preparedStatement.setInt(3, c.getNiveau().getId_niveau());
        preparedStatement.setInt(4, c.getId_classe());
        preparedStatement.executeUpdate();
        conn.close();
    }

    /**
     * Afficher les classes
     * */
    public ArrayList<Classe> afficherClasse() throws SQLException, IOException, ClassNotFoundException {

        connexionDB();
        ArrayList<Classe> classes = new ArrayList<>();

        String query = "SELECT *, niveau.libelle FROM classe, niveau where classe.id_niveau = niveau.id_niveau";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            Classe classe = new Classe();
            Niveau niveau = new Niveau();

            int id_classe = rs.getInt("classe.id_classe");
            String nom = rs.getString("classe.nom");
            int annee = rs.getInt("classe.annee");
            int id_niveau = rs.getInt("classe.id_niveau");
            String libelle = rs.getString("niveau.libelle");

            niveau.setId_niveau(id_niveau);
            niveau.setLibelle(libelle);

            System.out.println(nom);

            classe.setNom(nom);
            classe.setAnnee(annee);
            classe.setNiveau(niveau);
            classe.setId_classe(id_classe);
            classes.add(classe);
        }
        System.out.println(classes);
        conn.close();

        return classes;
    }

    /**
     * Supprimer une classe
     * */
    public void supprimerClasse(int id_classe) throws SQLException, IOException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        connexionDB();
        System.out.println(id_classe);
        // connexion = daoFactory.getConnection();
        preparedStatement = conn.prepareStatement("DELETE FROM classe where id_classe=?;");
        preparedStatement.setInt(1, id_classe);
        preparedStatement.executeUpdate();
        conn.close();
    }

    /**
     * Selectionne un niveau par id
     * */
    public Niveau getNiveauFromId(int id) throws SQLException, IOException, ClassNotFoundException {
        connexionDB();
        Niveau niveau = new Niveau();

        String query = "SELECT * FROM niveau where niveau.id_niveau = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            niveau.setId_niveau(rs.getInt("niveau.id_niveau"));
            niveau.setLibelle(rs.getString("niveau.libelle"));
        }
        conn.close();

        return niveau;
    }

    /**
     * Selectionne une classe
     * */
    public Classe getClasseFromID ()throws SQLException, IOException, ClassNotFoundException {

        connexionDB();

        String query = "SELECT *, niveau.libelle FROM classe, niveau where classe.id_niveau = niveau.id_niveau";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Classe classe = new Classe();
        Niveau niveau = new Niveau();

        while (rs.next())
        {
            int id_classe = rs.getInt("classe.id_classe");
            String nom = rs.getString("classe.nom");
            int annee = rs.getInt("classe.annee");
            int id_niveau = rs.getInt("classe.id_niveau");
            String libelle = rs.getString("niveau.libelle");

            niveau.setId_niveau(id_niveau);
            niveau.setLibelle(libelle);

            System.out.println(nom);

            classe.setNom(nom);
            classe.setAnnee(annee);
            classe.setNiveau(niveau);
            classe.setId_classe(id_classe);
        }

        conn.close();

        return classe;
    }

}
