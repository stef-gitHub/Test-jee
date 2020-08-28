<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Classe" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: stef4
  Date: 26/08/2020
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../assets/css/bootstrap.min.css" %>
        <%@include file="../assets/css/style.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="assets/javascript/bootstrap.min.js"></script>
    <title>Gestion des classes</title>
</head>
<body style =" background-color: #DFEAC5;">
<nav style="background-color : #184012" class="navbar navbar-expand-sm navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="accueil">Accueil</a>

    <!-- Links -->
    <ul class="navbar-nav">
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
    </ul>
</nav>
<br>
<h1 class="display-3" style="text-align: center" >
</h1>
<hr>
<div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
    <div class="row">
        <div class="col-md-12">
            <br>
            <div class="float-right"> <!-- Button to Open the Modal -->
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#creerClasse">
                    Créer une classe
                </button>

                <!-- The Modal -->
                <div class="modal fade" id="creerClasse">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="classe" method="post">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Création d'un élève</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">

                                    <div class="form-group">
                                        <label for="creerNomClasse">Nom</label>
                                        <input type="text" class="form-control" id="creerNomClasse" name="creerNomClasse" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="creerAnneeClasse">Année</label>
                                        <input type="number" min="1900" max="2099" step="1" value="2020" class="form-control" id="creerAnneeClasse" name="creerAnneeClasse" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Niveau</label>
                                        <div>
                                            <input type="radio" id="cp"
                                                   name="creerNiveauClasse" value="1">
                                            <label for="cp">CP</label>

                                            <input type="radio" id="ce1"
                                                   name="creerNiveauClasse" value="2">
                                            <label for="ce1">CE1</label>

                                            <input type="radio" id="ce2"
                                                   name="creerNiveauClasse" value="3">
                                            <label for="ce2">CE2</label>

                                            <input type="radio" id="cm1"
                                                   name="creerNiveauClasse" value="4">
                                            <label for="cm1">CM1</label>

                                            <input type="radio" id="cm2"
                                                   name="creerNiveauClasse" value="5">
                                            <label for="cm2">CM2</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <input type="submit" class="btn btn-success" name="submit" value="Créer"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <h2 style="text-align: center">Les classes</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th>Année</th>
                    <th>Niveau</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Classe> list = (ArrayList<Classe>)request.getAttribute("classes");
                    for (Classe classe : list) {
                %>
                <tr>
                    <td> <% out.println(classe.getNom());%></td>
                    <td> <% out.println(classe.getAnnee());%></td>
                    <td><% out.println(classe.getNiveau().getLibelle());%></td>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#creerClasse">
                            Créer une classe
                        </button>
                        <form action="classe" method="post">
                            <input hidden type="text" name="idClasse" value="<% out.println(classe.getId_classe());%>"/>
                            <input type="submit" class="btn btn-danger" name="supprimerClasse" value="Supprimer"/>
                        </form>

                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <br>
        <br>

    </div></div>
</body>
</html>
