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

        BouquinDAO bouquinDAO = new BouquinDAO();
        try {
            request.setAttribute("livres", bouquinDAO.displayLivre());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/bouquin.jsp" ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        try {
            BouquinDAO bouquinDAO = new BouquinDAO();

            if (request.getParameter("supprimerLivre") != null) {
                System.out.println("supprimer Livre!");
                bouquinDAO.supprimerLivre(Integer.parseInt(request.getParameter("id_livre")));
            } else if (request.getParameter("nomLivre") != null) {
                System.out.println("Livre creer !");
                Bouquin b = new Bouquin();
                b.setNom(request.getParameter("nomMateriel"));
                bouquinDAO.creerLivre(b);
            } else {
                // ???
            }
            response.sendRedirect("livre");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
