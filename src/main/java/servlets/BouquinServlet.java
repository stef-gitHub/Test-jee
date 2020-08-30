package servlets;


import beans.Bouquin;
import dao.BouquinDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BouquinServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("livres", BouquinDAO.displayLivre());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/bouquin.jsp" ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        try {
            BouquinDAO bouquinDAO = new BouquinDAO();

            if (request.getParameter("supprimerLivre") != null) {
                System.out.println("supprimer un livre :");
                bouquinDAO.supprimerLivre(Integer.parseInt(request.getParameter("id_livre")));

            } else if (request.getParameter("nomLivre") != null) {
                System.out.println("Création d'un livre : ");
                Bouquin b = new Bouquin();
                b.setNom(request.getParameter("nomLivre"));
                b.setAuteur(request.getParameter("nomAuteurLivre"));
                bouquinDAO.creerLivre(b);
            } else {
                // ???
            }
            response.sendRedirect("livre");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
