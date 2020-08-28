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
    EleveDAO eleveDAO = new EleveDAO();
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

        if (request.getParameter("nomEleveCreate") != null) {

            //CREATE Student
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

        } else if (request.getParameter("nomEleveUpdate") != null) {

            System.out.println("modifier !");
            Integer id = Integer.valueOf(request.getParameter("idEleveUpdate"));
            String nom = request.getParameter("nomEleveUpdate");
            String prenom = request.getParameter("prenomEleveUpdate");
            String adresse = request.getParameter("adresseEleveUpdate");
            Integer cp = Integer.valueOf(request.getParameter("cpEleveUpdate"));
            String ville = request.getParameter("villeEleveUpdate");
            String pere = request.getParameter("mereEleveUpdate");
            String mere = request.getParameter("pereEleveUpdate");


            try {
                Eleve e = eleveDAO.getElevebyIdPersonne(id);
                e.setNom(nom);
                e.setPrenom(prenom);
                e.setAdresse(adresse);
                e.setCp(cp);
                e.setVille(ville);
                e.setPere(pere);
                e.setMere(mere);

                EleveDAO.updateEleve(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

        } else {

        }



        response.sendRedirect("eleve");
    }
}
