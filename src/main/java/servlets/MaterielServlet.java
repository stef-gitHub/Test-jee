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

        MaterielDAO materielDAO = new MaterielDAO();
        try {
            request.setAttribute("materiels", materielDAO.displayMateriel());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/materiel.jsp" ).forward( request, response );
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        try {
            MaterielDAO materielDAO = new MaterielDAO();

            if (request.getParameter("supprimerMateriel") != null) {

                materielDAO.supprimerMateriel(Integer.parseInt(request.getParameter("id_materiel")));
            } else if (request.getParameter("nomMateriel") != null) {
                System.out.println("Materiel creer !");
                Materiel m = new Materiel();
                m.setNom(request.getParameter("nomMateriel"));
                materielDAO.creerMateriel(m);
            } else {
                // ???
            }
            response.sendRedirect("materiel");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}