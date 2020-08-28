package servlets;

import beans.Classe;
import beans.Eleve;
import beans.Professeur;
import dao.ClasseDAO;
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

        try {
            if (request.getParameter("supprimerProf") != null) {

                System.out.println("supprimer !");
                System.out.println(request.getParameter("idProf"));
                ProfesseurDAO.suppProf(Integer.valueOf(request.getParameter("idProf")));

            } else if (request.getParameter("nomProfesseurCreate") != null) {


                String nom = request.getParameter("nomProfesseurCreate");
                String prenom = request.getParameter("prenomProfesseurCreate");
                String adresse = request.getParameter("adresseProfesseurCreate");
                Integer cp = Integer.valueOf(request.getParameter("cpProfesseurCreate"));
                String ville = request.getParameter("villeProfesseurCreate");
                String mail = request.getParameter("mailProfesseurCreate");

                Professeur professeur = new Professeur();
                professeur.setNom(nom);
                professeur.setPrenom(prenom);
                professeur.setAdresse(adresse);
                professeur.setCp(cp);
                professeur.setVille(ville);
                professeur.setAdresse_mail(mail);

                ProfesseurDAO.addProfessor(professeur);

            } else if (request.getParameter("idProfModifier") != null) {

                System.out.println("modifier !");
                Professeur prof = new Professeur();
                prof = ProfesseurDAO.getProfFromId(Integer.parseInt(request.getParameter("idProfModifier")));
                prof.setNom(request.getParameter("nomProfesseurUpdate"));
                prof.setPrenom(request.getParameter("prenomProfesseurUpdate"));
                prof.setAdresse_mail(request.getParameter("mailProfesseurUpdate"));
                prof.setAdresse(request.getParameter("adresseProfesseurUpdate"));
                prof.setCp(Integer.valueOf(request.getParameter("cpProfesseurUpdate")));
                prof.setVille(request.getParameter("villeProfesseurUpdate"));

                ProfesseurDAO.modifierProfesseur(prof);

            } else {

            }

            response.sendRedirect("professeur");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
