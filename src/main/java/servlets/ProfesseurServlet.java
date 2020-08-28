package servlets;

import beans.Eleve;
import beans.Professeur;
import dao.EleveDAO;
import dao.ProfesseurDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProfesseurServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProfesseurDAO professeurDAO = new ProfesseurDAO();
        try {
            request.setAttribute("professeurs", professeurDAO.afficherProfesseur());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/professeur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nomProfesseurCreate");
        String prenom = request.getParameter("prenomProfesseurCreate");
        String adresse = request.getParameter("adresseProfesseurCreate");
        Integer cp = Integer.valueOf(request.getParameter("cpProfesseurCreate"));
        String ville = request.getParameter("villeProfesseurCreate");
        String mail = request.getParameter("mailProfesseurCreate");

        System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);

        Professeur professeur = new Professeur();
        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setAdresse(adresse);
        professeur.setCp(cp);
        professeur.setVille(ville);
        professeur.setAdresse_mail(mail);

        try {
           ProfesseurDAO.addProfessor(professeur);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("professeur");
    }

}
