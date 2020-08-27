package servlets;

import beans.Classe;
import dao.ClasseDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ClasseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClasseDAO classeDAO = new ClasseDAO();
        try {
            request.setAttribute("classes", classeDAO.afficherClasse());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( "/WEB-INF/classe.jsp" ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Classe classe = new Classe();
        classe.setAnnee(Integer.parseInt(request.getParameter("annee")));
        //classe.setId_niveau(Integer.parseInt(request.getParameter("niveau")));
        classe.setNom(request.getParameter("nom"));

        ClasseDAO classeDAO = new ClasseDAO();
        try {
            classeDAO.creerClasse(classe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/classe.jsp").forward(request, response);
    }
}