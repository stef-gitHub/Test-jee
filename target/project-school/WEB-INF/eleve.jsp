<%@ page import="beans.Personne" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Eleve" %><%--
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
    <title>Gestion des élèves</title>
</head>
<body style =" background-color: #EED4D6;">
<nav style="background-color : #97252D" class="navbar navbar-expand-sm navbar-dark">
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
<h1 class="display-3" style="text-align: center" >Gestion des élèves</h1>
<hr>
<div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
    <div class="row">
        <div class="col-md-12">
            <br>
            <div class="float-right"> <!-- Button to Open the Modal -->
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#createStudent">
                    Créer un élève
                </button>

                <!-- The Modal CREATE student-->
                <div class="modal fade" id="createStudent">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Création d'un élève</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="nomEleve">Nom</label>
                                        <input type="text" class="form-control" id="nomEleve" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="prenomEleve">Prénom</label>
                                        <input type="text" class="form-control" id="prenomEleve" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="adresseEleve">Adresse</label>
                                        <input type="text" class="form-control" id="adresseEleve" required>
                                    </div>

                                    <div class="form-group row" style="margin-left:1px">
                                        <div class="col-xs-2">
                                            <label for="cpEleve">Code Postal</label>
                                            <input type="text" class="form-control" id="cpEleve" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="villeEleve">Ville</label>
                                        <input type="text" class="form-control" id="villeEleve" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="pereEleve">Père</label>
                                        <input type="text" class="form-control" id="pereEleve">
                                    </div>
                                    <div class="form-group">
                                        <label for="mereEleve">Mère</label>
                                        <input type="text" class="form-control" id="mereEleve">
                                    </div>
                                </form>
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger mr-auto" data-dismiss="modal">Annuler</button>
                                <button type="button" class="btn btn-success" data-dismiss="modal">Créer</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <h2 style="text-align: center">Les élèves</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Père</th>
                    <th>Mère</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Eleve> listEleves = (ArrayList<Eleve>)request.getAttribute("eleves");
                    for (Eleve eleve : listEleves){
                %>
                <tr>

                    <td><% out.println(eleve.getNom());%></td>
                    <td><% out.println(eleve.getPrenom());%></td>
                    <td><% out.println(eleve.getPere());%></td>
                    <td><% out.println(eleve.getMere());%></td>
                    <td>
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updateStudent">Modifier</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStudent">Supprimer</button>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <br>
        <br>

        <!-- The Modal UPDATE student-->
        <div class="modal fade" id="updateStudent">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modifier un élève</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="nomEleve">Nom</label>
                                <input type="text" class="form-control" id="nomEleve" required>
                            </div>
                            <div class="form-group">
                                <label for="prenomEleve">Prénom</label>
                                <input type="text" class="form-control" id="prenomEleve" required>
                            </div>
                            <div class="form-group">
                                <label for="adresseEleve">Adresse</label>
                                <input type="text" class="form-control" id="adresseEleve" required>
                            </div>

                            <div class="form-group row" style="margin-left:1px">
                                <div class="col-xs-2">
                                    <label for="cpEleve">Code Postal</label>
                                    <input type="text" class="form-control" id="cpEleve" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="villeEleve">Ville</label>
                                <input type="text" class="form-control" id="villeEleve" required>
                            </div>
                            <div class="form-group">
                                <label for="pereEleve">Père</label>
                                <input type="text" class="form-control" id="pereEleve">
                            </div>
                            <div class="form-group">
                                <label for="mereEleve">Mère</label>
                                <input type="text" class="form-control" id="mereEleve">
                            </div>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger mr-auto" data-dismiss="modal">Annuler</button>
                        <button type="button" class="btn btn-success" data-dismiss="modal">Modifier</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- The Modal DELETE student-->
        <div class="modal fade" id="deleteStudent">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Supprimer un élève</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <p>Etes-vous sûr de vouloir supprimer cet élève ?</p>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger mr-auto" data-dismiss="modal">Annuler</button>
                        <button type="button" class="btn btn-success" data-dismiss="modal">Supprimer</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
