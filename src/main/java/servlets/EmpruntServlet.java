package servlets;

import beans.*;
import dao.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EmpruntServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfesseurDAO professeurDAO = new ProfesseurDAO();
        try {
            // Affichage des emprunts / professeurs / livres / materiels
            request.setAttribute("emprunts", EmpruntDAO.displayEmprunt());
            request.setAttribute("profs", professeurDAO.afficherProfesseur());
            request.setAttribute("livres", BouquinDAO.displayLivre());
            request.setAttribute("materiels", MaterielDAO.displayMateriel());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/emprunt.jsp" ).forward( request, response );
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        try {
            // Post de supression d'un emprunt
            if (request.getParameter("supprimerEmprunt") != null) {
                Emprunt emprunt = new Emprunt();
                System.out.println("supprimer !");
                emprunt.setProfesseur(EmpruntDAO.getProfFromId(Integer.parseInt(request.getParameter("deleteProf"))));
                emprunt.setBouquin(EmpruntDAO.getBouquinFromId(Integer.parseInt(request.getParameter("deleteLivre"))));
                emprunt.setMateriel(EmpruntDAO.getMaterielFromId(Integer.parseInt(request.getParameter("deleteMateriel"))));

                EmpruntDAO.deleteEmprunt(emprunt);
            }
            // Post de création d'un emprunt
            else if (request.getParameter("selectLivre") != null) {
                System.out.println("Emprunt créé !");
                Emprunt emprunt = new Emprunt();

                emprunt.setProfesseur(EmpruntDAO.getProfFromId(Integer.parseInt(request.getParameter("selectProf"))));
                emprunt.setBouquin(EmpruntDAO.getBouquinFromId(Integer.parseInt(request.getParameter("selectLivre"))));
                emprunt.setMateriel(EmpruntDAO.getMaterielFromId(Integer.parseInt(request.getParameter("selectMateriel"))));

                EmpruntDAO.addEmprunt(emprunt);
            }
            response.sendRedirect("emprunt");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}