package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
    }
    /**
     * Pour simuler une interface de connexion sans BDD
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        if (request.getParameter("login") != null){

            String login = request.getParameter("login");
            String mdp  = request.getParameter("mdp");

            if (login.equals("Florian") && mdp.equals("a")){

                session.setAttribute("login", login);
                response.sendRedirect("accueil");
            }
            else{
                response.sendRedirect("login");
                System.out.println("login et/ou mot de passe invalide");
            }
        }
    }
}
