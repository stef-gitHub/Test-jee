<%@ page import="beans.Professeur" %>
<%@ page import="java.util.List" %>
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

    <title>Gestion des professeurs</title>
</head>
<body style =" background-color: #E1E1E1;">
<nav style="background-color : #373737" class="navbar navbar-expand-sm navbar-dark">
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
<h1 class="display-3" style="text-align: center" >Gestion des professeurs</h1>
<hr>
<div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
    <div class="row">
        <div class="col-md-12">
            <br>
            <div class="float-right"> <!-- Button to Open the Modal -->
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#createProfesseur">
                    Créer un professeur
                </button>

                <!-- The Modal CREATE -->
                <div class="modal fade" id="createProfesseur">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="professeur" method="post">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Création d'un professeur</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">

                                    <div class="form-group">
                                        <label for="nomProfesseurCreate">Nom</label>
                                        <input type="text" class="form-control" id="nomProfesseurCreate" name="nomProfesseurCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="prenomProfesseurCreate">Prénom</label>
                                        <input type="text" class="form-control" id="prenomProfesseurCreate" name="prenomProfesseurCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="adresseProfesseurCreate">Adresse</label>
                                        <input type="text" class="form-control" id="adresseProfesseurCreate" name="adresseProfesseurCreate" required>
                                    </div>

                                    <div class="form-group row" style="margin-left:1px">
                                        <div class="col-xs-2">
                                        <label for="cpProfesseurCreate">Code Postal</label>
                                        <input type="text" class="form-control" id="cpProfesseurCreate" name="cpProfesseurCreate" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="villeProfesseurCreate">Ville</label>
                                        <input type="text" class="form-control" id="villeProfesseurCreate" name="villeProfesseurCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="mailProfesseurCreate">Adresse mail</label>
                                        <input type="text" class="form-control" id="mailProfesseurCreate" name="mailProfesseurCreate" >
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
            <h2 style="text-align: center">Les professeurs</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Email</th>
                    <th>Actions</th>
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
                    <td>
                        <input data-toggle="modal" data-target="#updateProfesseur" type="button" class="btn btn-success" onclick="modifier('<% out.print(professeur.getId_personne());%>', '<% out.print(professeur.getAdresse_mail());%>', '<% out.print(professeur.getAdresse());%>', '<% out.print(professeur.getCp());%>', '<% out.print(professeur.getVille());%>', '<% out.print(professeur.getNom());%>', '<% out.print(professeur.getPrenom());%>')" value="modifier"/>
                        <form action="professeur" method="post">
                            <input hidden type="text" name="idProf" value="<% out.print(professeur.getId_personne());%>"/>
                            <input type="submit" class="btn btn-danger" name="supprimerProf" value="Supprimer"/>
                        </form>
                    </td>
                </tr>
                </tbody>
                <% } %>
            </table>
        </div>
        <br>
        <br>

    </div>

    <!-- The Modal UPDATE -->
    <div class="modal fade" id="updateProfesseur">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Modifier un professeur</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form action="professeur" method="post">
                        <input hidden type="text" value="" name="idProfModifier" id="idProfModifier"/>

                        <div class="form-group">
                            <label for="nomProfesseurUpdate">Nom</label>
                            <input type="text" class="form-control" id="nomProfesseurUpdate" name="nomProfesseurUpdate" required>
                        </div>
                        <div class="form-group">
                            <label for="prenomProfesseurUpdate">Prénom</label>
                            <input type="text" class="form-control" id="prenomProfesseurUpdate" name="prenomProfesseurUpdate" required>
                        </div>
                        <div class="form-group">
                            <label for="adresseProfesseurUpdate">Adresse</label>
                            <input type="text" class="form-control" id="adresseProfesseurUpdate" name="adresseProfesseurUpdate" required>
                        </div>

                        <div class="form-group row" style="margin-left:1px">
                            <div class="col-xs-2">
                                <label for="cpProfesseurUpdate">Code Postal</label>
                                <input type="text" class="form-control" id="cpProfesseurUpdate" name="cpProfesseurUpdate" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="villeProfesseurUpdate">Ville</label>
                            <input type="text" class="form-control" id="villeProfesseurUpdate" name="villeProfesseurUpdate" required>
                        </div>
                        <div class="form-group">
                            <label for="mailProfesseurUpdate">Adresse mail</label>
                            <input type="text" class="form-control" id="mailProfesseurUpdate" name="mailProfesseurUpdate">
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" name="submit" value="Modifier"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- The Modal DELETE -->
    <div class="modal fade" id="deleteProfesseur">
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
<script>
    function modifier(id, mail, adresse, cp, ville, nom, prenom){
        $("#idProfModifier").attr('value', id);
        $("#nomProfesseurUpdate").attr('value', nom);
        $("#prenomProfesseurUpdate").attr('value', prenom);
        $("#adresseProfesseurUpdate").attr('value', adresse);
        $("#cpProfesseurUpdate").attr('value', cp);
        $("#villeProfesseurUpdate").attr('value', ville);
        $("#mailProfesseurUpdate").attr('value', mail);

    }
</script>
</html>
