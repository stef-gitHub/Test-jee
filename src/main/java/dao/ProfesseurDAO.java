package dao;

import java.sql.*;

public class ProfesseurDAO {

    public static void addProfesseur(Connection con, String nom, String prenom, String adresse, int cp, String ville, String mail) throws SQLException, ClassNotFoundException{

        // the mysql insert statement
        String query = " insert into professeur (nom, prenom, adresse, cp, ville, contact)"
                + " values (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, nom);
        preparedStmt.setString (2, prenom);
        preparedStmt.setString (3, adresse);
        preparedStmt.setInt (4, cp);
        preparedStmt.setString (5, ville);
        preparedStmt.setString (6, mail);

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(nom +" "+ nom + " a été ajouté ");
    }

    public static void deleteProfesseur(Connection con, int id) throws SQLException, ClassNotFoundException{
        String query = "Delete FROM professeur where id_professeur = ? ";

        try (PreparedStatement preparedStmt = con.prepareStatement(query)) {
            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            System.out.println("id : " + id + " supprimé !");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateProfesseur(Connection con, String nom, String prenom, String adresse, int cp, String ville, String mail, int id) throws SQLException, ClassNotFoundException{
        String query = "Update professeur set nom = ?, prenom = ?, adresse = ?, cp = ?, ville = ?, mail = ? where id_professeur = ?";

        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setString(1, nom);
        preparedStmt.setString(2, prenom);
        preparedStmt.setString(3, adresse);
        preparedStmt.setInt (4, cp);
        preparedStmt.setString (5, ville);
        preparedStmt.setString (6, mail);
        preparedStmt.setInt(4, id);
        preparedStmt.executeUpdate();

        System.out.println("id : " + id + " mis à jour !");


    }


}
