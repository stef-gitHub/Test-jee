package servlets;

import beans.*;
import dao.*;

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
        ProfesseurDAO professeurDAO = new ProfesseurDAO();
        try {
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
        Bouquin b = new Bouquin();
        Professeur p = new Professeur();
        Materiel m = new Materiel();
        /**
         * try {
             if (request.getParameter("selectLivre") != null) {
                System.out.println("Emprunt créé !");
                Emprunt emprunt = new Emprunt();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.FRENCH);

                int idProf = Integer.parseInt(request.getParameter("selectProf"));
                p.setId_personne(idProf);
                int idLivre = Integer.parseInt(request.getParameter("selectLivre"));
                b.setId_bouquin(idLivre);
                int idMateriel = Integer.parseInt(request.getParameter("selectMateriel"));
                m.setId_materiel(idMateriel);

                emprunt.setProfesseur(p);
                emprunt.setBouquin(b);
                emprunt.setMateriel(m);

                EmpruntDAO.addEmprunt(emprunt);
                System.out.println(emprunt);
            }*/
            response.sendRedirect("emprunt");

        /**} catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/
    }
}