package servlets;

import beans.Eleve;
import dao.EleveDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class EleveServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setAttribute("eleves", EleveDAO.displayEleve());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/eleve.jsp" ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nomEleveCreate");
        String prenom = request.getParameter("prenomEleveCreate");
        String adresse = request.getParameter("adresseEleveCreate");
        Integer cp = Integer.valueOf(request.getParameter("cpEleveCreate"));
        String ville = request.getParameter("villeEleveCreate");
        String pere = request.getParameter("pereEleveCreate");
        String mere = request.getParameter("mereEleveCreate");

        System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);

        Eleve eleve = new Eleve();
        eleve.setNom(nom);
        eleve.setPrenom(prenom);
        eleve.setAdresse(adresse);
        eleve.setCp(cp);
        eleve.setVille(ville);
        eleve.setPere(pere);
        eleve.setMere(mere);

        try {
            EleveDAO.addEleve(eleve);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("eleve");
    }
}
