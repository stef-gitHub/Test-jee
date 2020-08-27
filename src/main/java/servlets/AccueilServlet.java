package servlets;

import connexion.test;
import beans.Personne;
import beans.Classe;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccueilServlet extends HttpServlet {

     // ConnexionDB.connexionTest();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Création et initialisation du message. */
        String paramAuteur = request.getParameter( "auteur" );
        String message = "Transmission de variables : OK ! " + paramAuteur;
        /* Création du bean */
        Personne premierBean = new Personne();
        /* Initialisation de ses propriétés */
        premierBean.setNom( "Mon Nom" );
        premierBean.setPrenom( "Mon prénom" );
        /* Stockage du message et du bean dans l'objet request */
        request.setAttribute( "test", message );
        request.setAttribute( "personne", premierBean );
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" ).forward( request, response );
    }
}