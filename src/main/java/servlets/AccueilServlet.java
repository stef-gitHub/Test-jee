package servlets;

import dao.ClasseDAO;
import dao.EleveDAO;
import dao.EmpruntDAO;
import dao.ProfesseurDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccueilServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        ProfesseurDAO professeurDAO = new ProfesseurDAO();
        ClasseDAO classeDAO = new ClasseDAO();

            try {
                // Affichage des professeurs / classes / eleves / emprunts
                request.setAttribute("professeurs", professeurDAO.afficherProfesseur());
                request.setAttribute("classes", classeDAO.afficherClasse());
                request.setAttribute("eleves", EleveDAO.displayEleve());
                request.setAttribute("emprunts", EmpruntDAO.displayEmprunt());

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
}