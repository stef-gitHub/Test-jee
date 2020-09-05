<%@ page import="beans.Emprunt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Professeur" %>
<%@ page import="beans.Bouquin" %>
<%@ page import="beans.Materiel" %><%--
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
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login">Se déconnecter</a>
            </li>
        </ul>
    </div>
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

                                <!-- Modal CREATE Header -->
                                <div class="modal-header background-color-emprunt">
                                    <h4 class="modal-title text-color-items">Création d'un emprunt</h4>
                                    <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal CREATE body -->
                                <div class="modal-body">
                                    <div class="form-group">
                                        <h4>Sélectionnez un professeur</h4>
                                        <select id="selectProfesseurs" name="selectProf">
                                            <%
                                                List<Professeur> listProfs = (ArrayList<Professeur>)request.getAttribute("profs");
                                                for (Professeur profs : listProfs) {
                                            %>
                                            <option style="white-space: pre" value=<%out.println(profs.getId_professeur());%>><% out.println(profs.getNom());%> <% out.println(profs.getPrenom());%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <hr>
                                    <br>
                                    <div class="form-group">
                                        <h4>Sélectionnez un livre</h4>
                                        <select class="selectpicker" id="selectLivre" name="selectLivre">
                                            <%
                                                List<Bouquin> listLivres = (ArrayList<Bouquin>)request.getAttribute("livres");
                                                for (Bouquin livres : listLivres) {
                                            %>
                                            <option style="white-space: pre" value=<% out.println(livres.getId_bouquin());%>><% out.println(livres.getNom());%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <hr>
                                    <br>
                                    <div class="form-group">
                                        <h4>Sélectionnez un matériel</h4>
                                        <select id="selectMateriel" name="selectMateriel">
                                            <%
                                                List<Materiel> listMateriel = (ArrayList<Materiel>)request.getAttribute("materiels");
                                                for (Materiel materiels : listMateriel) {
                                            %>
                                            <option value=<% out.println(materiels.getId_materiel());%>><% out.println(materiels.getNom());%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <!-- Modal CREATE footer -->
                                    <input type="submit" class="btn btn-success float-right" name="submit" value="Créer"/>
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
                    <th>Date d'emprunt</th>
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
                    <td>
                        <div class="float-right">
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#supprimerEmprunt<% out.print(emprunt.getProfesseur().getId_professeur());%><% out.print(emprunt.getBouquin().getId_bouquin());%><% out.print(emprunt.getMateriel().getId_materiel());%>">Supprimer</button>
                            <!-- The Modal Professor DELETE -->
                            <div class="modal fade" id="supprimerEmprunt<% out.print(emprunt.getProfesseur().getId_professeur());%><% out.print(emprunt.getBouquin().getId_bouquin());%><% out.print(emprunt.getMateriel().getId_materiel());%>">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal DELETE Header -->
                                        <div class="modal-header background-color-emprunt">
                                            <h4 class="modal-title text-color-items">Supprimer un emprunt</h4>
                                            <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal DELETE body -->
                                        <div class="modal-body text-center">
                                            <p>Etes-vous sûr de vouloir supprimer l'emprunt de :</p>
                                            <p><span style="font-weight: bold ; font-size: 20px"><% out.print(emprunt.getProfesseur().getNom());%> <% out.print(emprunt.getProfesseur().getPrenom());%> </span>? </p>
                                            <hr>
                                            <p>Livre : <% out.print(emprunt.getBouquin().getNom());%></p>
                                            <p>Matériel : <% out.print(emprunt.getMateriel().getNom());%></p>
                                            <p>Date d'emprunt : <% out.print(emprunt.getDate_debut());%></p>
                                        </div>
                                        <!-- Modal DELETE footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success mr-auto" data-dismiss="modal">Annuler</button>
                                            <form action="emprunt" method="post">
                                                <input hidden type="text" name="deleteProf" value="<% out.print(emprunt.getProfesseur().getId_professeur());%>"/>
                                                <input hidden type="text" name="deleteLivre" value="<% out.print(emprunt.getBouquin().getId_bouquin());%>"/>
                                                <input hidden type="text" name="deleteMateriel" value="<% out.print(emprunt.getMateriel().getId_materiel());%>"/>
                                                <input type="submit" class="btn btn-danger" name="supprimerEmprunt" value="Supprimer"/>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <br>
        <br>
    </div>
    <!-- The Modal DELETE -->
    <div class="modal fade" id="deleteEmprunt">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Supprimer un professeur</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <p>Etes-vous sûr de vouloir supprimer ce professeur ? </p>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-success mr-auto" data-dismiss="modal">Annuler</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Supprimer</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
