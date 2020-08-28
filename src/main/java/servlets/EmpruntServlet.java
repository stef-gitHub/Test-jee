package servlets;

import beans.Classe;
import beans.Emprunt;
import dao.ClasseDAO;
import dao.EmpruntDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class EmpruntServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("emprunts", EmpruntDAO.displayEmprunt());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/emprunt.jsp" ).forward( request, response );
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        try {
             if (request.getParameter("creerEmprunt") != null) {
                System.out.println("Emprunt créé !");
                Emprunt emprunt = new Emprunt();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.FRENCH);

                int idProf = Integer.parseInt(request.getParameter("creerProfesseur"));
                emprunt.setProfesseur(EmpruntDAO.getProfFromId(idProf));

                int idLivre = Integer.parseInt(request.getParameter("creerLivre"));
                emprunt.setBouquin(EmpruntDAO.getBouquinFromId(idLivre));

                int idMateriel = Integer.parseInt(request.getParameter("creerMateriel"));
                emprunt.setMateriel(EmpruntDAO.getMateriel(idMateriel));

                EmpruntDAO.addEmprunt(emprunt);
            }
            response.sendRedirect("emprunt");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}