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

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        try {
        ClasseDAO classeDAO = new ClasseDAO();

        if (request.getParameter("supprimerClasse") != null) {

            System.out.println("supprimer !");
            classeDAO.supprimerClasse(Integer.parseInt(request.getParameter("idClasse")));

        } else if (request.getParameter("creerNomClasse") != null) {

            System.out.println("creer !");
            Classe c = new Classe();
            c.setNom(request.getParameter("creerNomClasse"));
            c.setAnnee(Integer.parseInt(request.getParameter("creerAnneeClasse")));
            int idNiveau = Integer.parseInt(request.getParameter("creerNiveauClasse"));
            c.setNiveau(classeDAO.getNiveauFromId(idNiveau));
            classeDAO.creerClasse(c);

        } else if (request.getParameter("modifierNomClasse") != null) {

            System.out.println("modifier !");
            Classe c = new Classe();
            c = classeDAO.getClasseFromID(Integer.parseInt(request.getParameter("idclasseModifier")));
            c.setNom(request.getParameter("modifierNomClasse"));
            c.setAnnee(Integer.parseInt(request.getParameter("modifierAnneeClasse")));
            c.setNiveau(classeDAO.getNiveauFromId(Integer.parseInt(request.getParameter("modifierNiveauClasse"))));
            classeDAO.modifierClasse(c);

        } else {

        }

        response.sendRedirect("classe");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}