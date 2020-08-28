<%@ page import="beans.Emprunt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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
    <title>Gestion des emprunts</title>
</head>
<body style =" background-color: #D7C49A;">
<nav style="background-color : #B98200" class="navbar navbar-expand-sm navbar-dark">
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
<h1 class="display-3" style="text-align: center" >Gestion des emprunts</h1>
<hr>
<div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
    <div class="row">
        <div class="col-md-12">
            <br>
            <div class="float-right"> <!-- Button to Open the Modal -->
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                    Créer un emprunt
                </button>

                <!-- The Modal -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="emprunt" method="post">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Création d'un élève</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <div class="form-group">
                                        <select id="selectProfesseurs" name="creerProfesseur">
                                            <%
                                                List<Emprunt> listProfs = (ArrayList<Emprunt>)request.getAttribute("emprunts");
                                                for (Emprunt emprunts : listProfs) {
                                            %>
                                            <option value="<% out.println(emprunts.getProfesseur().getId_professeur());%>"><% out.println(emprunts.getProfesseur().getNom());%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                        <br>
                                    <div class="form-group">
                                        <select id="selectLivre" name="creerLivre">
                                            <%
                                                List<Emprunt> listLivres = (ArrayList<Emprunt>)request.getAttribute("emprunts");
                                                for (Emprunt emprunts : listLivres) {
                                            %>
                                            <option value="<% out.println(emprunts.getBouquin().getId_bouquin());%>"><% out.println(emprunts.getBouquin().getNom());%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                        <br>
                                        <div class="form-group">
                                            <select id="selectMateriel" name="creerMateriel">
                                                <%
                                                    List<Emprunt> listMateriel = (ArrayList<Emprunt>)request.getAttribute("emprunts");
                                                    for (Emprunt emprunts : listMateriel) {
                                                %>
                                                <option value="<% out.println(emprunts.getMateriel().getId_materiel());%>"><% out.println(emprunts.getMateriel().getNom());%></option>
                                                <% } %>
                                            </select>
                                        </div>
                                <!-- Modal footer -->
                                    <input type="submit" class="btn btn-danger" name="creerEmprunt" value="créer"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <h2 style="text-align: center">Les emprunts</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Professeur</th>
                    <th>Livre</th>
                    <th>Matériel</th>
                    <th>Date début</th>
                    <th>Date fin</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Emprunt> listEmprunt = (ArrayList<Emprunt>)request.getAttribute("emprunts");
                    for (Emprunt emprunt : listEmprunt) {
                %>
                <tr>
                    <td> <% out.println(emprunt.getProfesseur().getNom());%>  <% out.println(emprunt.getProfesseur().getPrenom());%> </td>
                    <td> <% out.println(emprunt.getBouquin().getNom());%></td>
                    <td> <% out.println(emprunt.getMateriel().getNom());%></td>
                    <td> <% out.println(emprunt.getDate_debut());%></td>
                    <td> <% out.println(emprunt.getDate_fin());%></td>
                    <td>
                        <form action="emprunt" method="post">
                            <input hidden type="text" name="idEmprunt" value="<% out.print(emprunt.getId_emprunt());%>"/>
                            <input type="submit" class="btn btn-danger" name="supprimerEmprunt" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <br>
        <br>
    </div>
</body>
</html>
