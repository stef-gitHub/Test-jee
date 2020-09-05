package servlets;

import beans.Materiel;
import dao.MaterielDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MaterielServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Affichage de tout le matériel
        try {
            request.setAttribute("materiels", MaterielDAO.displayMateriel());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/materiel.jsp" ).forward( request, response );
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {


        try {
            MaterielDAO materielDAO = new MaterielDAO();

            // Post de supression d'un matériel
            if (request.getParameter("supprimerMateriel") != null) {
                materielDAO.supprimerMateriel(Integer.parseInt(request.getParameter("id_materiel")));

            // Post de création d'un matériel
            } else if (request.getParameter("nomMateriel") != null) {

                Materiel m = new Materiel();
                m.setNom(request.getParameter("nomMateriel"));
                materielDAO.creerMateriel(m);

                System.out.println("Materiel créé");
            }

            response.sendRedirect("materiel");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}