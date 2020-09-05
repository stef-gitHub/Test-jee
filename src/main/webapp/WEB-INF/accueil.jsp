<%@ page import="beans.Professeur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Classe" %>
<%@ page import="beans.Eleve" %>
<%@ page import="beans.Emprunt" %><%--
  Created by IntelliJ IDEA.
  User: stef4
  Date: 26/08/2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../assets/css/bootstrap.min.css" %>
        <%@include file="../assets/css/style.css" %>
    </style>
    <script src="../assets/javascript/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="../assets/javascript/bootstrap.min.js"></script>
    <title>Accueil</title>
</head>
<body style =" background-color: #c47e7e2b;" >
<nav style="background-color: #9E2772" class="navbar navbar-expand-md navbar-dark ">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="navbar-brand" href="accueil">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="professeur">Professeurs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="eleve">Elèves</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="classe">Classes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="emprunt">Emprunts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="materiel">Matériels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="livre">Livres</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto">Bienvenue ${ sessionScope.login } !</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login">Se déconnecter</a>
            </li>
        </ul>
    </div>
</nav>
    <br>
    <div style="text-align: center"><h1 style="font-size: 80px; font-family: Lucida Console, Courier, monospace; ">Tableau de bord</h1></div>
    <div style ="background-color: white;margin-top: 30px; max-width: 80%" class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 style="text-align: center">Les professeurs</h2>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%
                        List<Professeur> list = (ArrayList<Professeur>)request.getAttribute("professeurs");
                        for (Professeur professeur : list) {
                    %>
                    <tr>

                        <td> <% out.println(professeur.getNom());%></td>
                        <td> <% out.println(professeur.getPrenom());%></td>
                        <td> <% out.println(professeur.getAdresse_mail());%></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
            <br>
            <br>
            <div class="col-md-6">
                <h2 style="text-align: center">Les classes</h2>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Nom</th>
                        <th>Année</th>
                        <th>Niveau</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Classe> listeClasse = (ArrayList<Classe>)request.getAttribute("classes");
                        for (Classe classe : listeClasse) {
                    %>
                    <tr>
                        <td> <% out.println(classe.getNom());%></td>
                        <td> <% out.println(classe.getAnnee());%></td>
                        <td><% out.println(classe.getNiveau().getLibelle());%></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <br>
        <br>
        <br>
        <div style="padding-bottom: 20px;" class="row">
            <div class="col-md-6">
                <div style="background-color: #D1F185;border-radius: 10px" class="col-md-12">
                    <h2 style="text-align: center">Effectifs</h2>
                    </br>
                    <% List<Eleve> listEleves = (ArrayList<Eleve>)request.getAttribute("eleves"); %>
                    <h3>Nombre d'élèves : <% out.println(listEleves.size());%></h3>
                    <h3>Nombre de professeurs : <% out.println(list.size());%></h3>
                    <h3>Total :
                        <%
                            int operand1 = listEleves.size(), operand2 = list.size(), sum;
                            sum = operand1 + operand2;
                            out.println(sum);
                        %>
                    </h3>
                    <br>
                </div>
            </div>
            <div class="col-md-6 ">
                <div style="background-color: #FFA24F; border-radius: 10px" class="col-md-12">
                    <h2 style="text-align: center">Emprunts</h2>
                    </br>
                    <%
                        List<Emprunt> listEmprunt = (ArrayList<Emprunt>)request.getAttribute("emprunts");
                    %>
                    <h3>Emprunts mois en cours :</h3>
                    <h3> Nombre d'emprunteurs :</h3>
                    <h3>Total : <% out.println(listEmprunt.size());%></h3>
                    <br>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
