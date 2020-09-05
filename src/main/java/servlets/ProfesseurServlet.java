package servlets;

import beans.Professeur;
import dao.ProfesseurDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProfesseurServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Affichage des professeurs
        ProfesseurDAO professeurDAO = new ProfesseurDAO();
        try {
            request.setAttribute("professeurs", professeurDAO.afficherProfesseur());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/professeur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        try {
            // Post de supression professeur
            if (request.getParameter("supprimerProf") != null) {

                System.out.println("supprimer !");
                ProfesseurDAO.suppProf(Integer.valueOf(request.getParameter("idProf")));

            // Post de création professeur
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

            // Post de modification professeur
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
            }

            response.sendRedirect("professeur");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
