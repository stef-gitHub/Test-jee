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
                            <form action="eleve" method="post">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Création d'un élève</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">

                                    <div class="form-group">
                                        <label for="nomEleveCreate">Nom</label>
                                        <input type="text" class="form-control" id="nomEleveCreate" required name="nomEleveCreate">
                                    </div>
                                    <div class="form-group">
                                        <label for="prenomEleveCreate">Prénom</label>
                                        <input type="text" class="form-control" id="prenomEleveCreate" name="prenomEleveCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="adresseEleveCreate">Adresse</label>
                                        <input type="text" class="form-control" id="adresseEleveCreate" name="adresseEleveCreate" required>
                                    </div>

                                    <div class="form-group row" style="margin-left:1px">
                                        <div class="col-xs-2">
                                            <label for="cpEleveCreate">Code Postal</label>
                                            <input type="text" class="form-control" id="cpEleveCreate" name="cpEleveCreate" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="villeEleveCreate">Ville</label>
                                        <input type="text" class="form-control" id="villeEleveCreate" name="villeEleveCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="pereEleveCreate">Père</label>
                                        <input type="text" class="form-control" id="pereEleveCreate" name="pereEleveCreate">
                                    </div>
                                    <div class="form-group">
                                        <label for="mereEleveCreate">Mère</label>
                                        <input type="text" class="form-control" id="mereEleveCreate" name="mereEleveCreate">
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
            <h2 style="text-align: center">Les élèves</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th class="hide">id</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Père</th>
                    <th>Mère</th>
                    <th>Adresse</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Eleve> listEleves = (ArrayList<Eleve>)request.getAttribute("eleves");
                    for (Eleve eleve : listEleves){
                %>
                <tr>
                    <td><% out.println(eleve.getId_personne());%></td>
                    <td><% out.println(eleve.getNom());%></td>
                    <td><% out.println(eleve.getPrenom());%></td>
                    <td><% out.println(eleve.getPere());%></td>
                    <td><% out.println(eleve.getMere());%></td>
                    <td><% out.println(eleve.getAdresse());%></td>
                    <td>
                        <input data-toggle="modal" data-target="#updateStudent" type="button" class="btn btn-success" onclick="update('<%=eleve.getId_personne()%>', '<%=eleve.getNom()%>', '<%=eleve.getPrenom()%>', '<%=eleve.getAdresse()%>', '<%=eleve.getCp()%>', '<%=eleve.getVille()%>', '<%=eleve.getPere()%>', '<%=eleve.getMere()%>')" value="Modifier"/>

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
                    <form action="eleve" method="post">
                        <input hidden type="text" name="idEleve" value="" id="idEleveUpdate"/>
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modifier un élève</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">

                            <div class="form-group">
                                <label for="nomEleveUpdate">Nom</label>
                                <input type="text" class="form-control" id="nomEleveUpdate" name="nomEleveUpdate">
                            </div>
                            <div class="form-group">
                                <label for="prenomEleveUpdate">Prénom</label>
                                <input type="text" class="form-control" id="prenomEleveUpdate" name="prenomEleveUpdate">
                            </div>
                            <div class="form-group">
                                <label for="adresseEleveUpdate">Adresse</label>
                                <input type="text" class="form-control" id="adresseEleveUpdate" name="adresseEleveUpdate">
                            </div>

                            <div class="form-group row" style="margin-left:1px">
                                <div class="col-xs-2">
                                    <label for="cpEleveUpdate">Code Postal</label>
                                    <input type="text" class="form-control" id="cpEleveUpdate" name="cpEleveUpdate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="villeEleveUpdate">Ville</label>
                                <input type="text" class="form-control" id="villeEleveUpdate" name="villeEleveUpdate">
                            </div>
                            <div class="form-group">
                                <label for="pereEleveUpdate">Père</label>
                                <input type="text" class="form-control" id="pereEleveUpdate" name="pereEleveUpdate">
                            </div>
                            <div class="form-group">
                                <label for="mereEleveUpdate">Mère</label>
                                <input type="text" class="form-control" id="mereEleveUpdate" name="mereEleveUpdate">
                            </div>

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
</div>
</body>
<script>
    function update(id_eleve, nom, prenom, adresse, code_postal, ville, pere, mere){
        $("#idEleveUpdate").attr('value', id_eleve);
        $("#nomEleveUpdate").attr('value', nom);
        $("#prenomEleveUpdate").attr('value', prenom);
        $("#adresseEleveUpdate").attr('value', adresse);
        $("#cpEleveUpdate").attr('value', code_postal);
        $("#villeEleveUpdate").attr('value', ville);
        $("#pereEleveUpdate").attr('value', pere);
        $("#mereEleveUpdate").attr('value', mere);
    }
</script>
</html>
