package servlets;

import beans.Eleve;
import dao.EleveDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EleveServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Affichage des élèves
        try {
            request.setAttribute("eleves", EleveDAO.displayEleve());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( "/WEB-INF/eleve.jsp" ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try {
            // Post de supression d'un élève
            if (request.getParameter("deleteEleve") != null){

                System.out.println("Suppression d'un élève :");
                EleveDAO.deleteEleve(Integer.valueOf(request.getParameter("idEleve")));
            }
            // Post de création éleve
            else if (request.getParameter("nomEleveCreate") != null) {

                System.out.println("Création d'un élève :");

                String nom = request.getParameter("nomEleveCreate");
                String prenom = request.getParameter("prenomEleveCreate");
                String adresse = request.getParameter("adresseEleveCreate");
                // Permet d'éviter une erreur de Type dans le form
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

                EleveDAO.addEleve(eleve);

            // Post de modification Eleve
            }  else if (request.getParameter("idEleveUpdate") != null) {

                System.out.println("Moficiation d'un élève :");
                Eleve eleve = new Eleve();
                eleve = EleveDAO.getEleveFromId(Integer.parseInt(request.getParameter("idEleveUpdate")));
                eleve.setNom(request.getParameter("nomEleveUpdate"));
                eleve.setPrenom(request.getParameter("prenomEleveUpdate"));
                eleve.setAdresse(request.getParameter("adresseEleveUpdate"));
                eleve.setCp(Integer.valueOf(request.getParameter("cpEleveUpdate")));
                eleve.setVille(request.getParameter("villeEleveUpdate"));
                eleve.setMere(request.getParameter("mereEleveUpdate"));
                eleve.setPere(request.getParameter("pereEleveUpdate"));

                EleveDAO.updateEleve(eleve);
            }

            response.sendRedirect("eleve");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
