<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Materiel" %>
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
    <title>Gestion du matériel</title>
</head>
<body style =" background-color: #E1E1E1;">
    <nav style="background-color : #373737" class="navbar navbar-expand-sm navbar-dark">
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
    <h1 class="display-3" style="text-align: center" >Gestion du matériel</h1>
    <hr>
    <div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
        <div class="row">
            <div class="col-md-12">
                <br>
                <div class="float-right"> <!-- Button to Open the Modal -->
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#createMateriel">Créer un matériel</button>
                    <!-- The Modal CREATE -->
                    <div class="modal fade" id="createMateriel">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="materiel" method="post">
                                    <!-- Modal CREATE Header -->
                                    <div class="modal-header background-color-professeur">
                                        <h4 class="modal-title text-color-items">Création d'un matériel</h4>
                                        <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- Modal CREATE body -->
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="nomMateriel">Nom</label>
                                            <input type="text" class="form-control" id="nomMateriel" name="nomMateriel" required>
                                        </div>
                                    </div>

                                    <!-- Modal CREATE footer -->
                                    <div class="modal-footer">
                                        <input type="submit" class="btn btn-success" name="submit" value="Créer"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <h2 style="text-align: center">Les Matériels</h2>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Nom</th>
                        <th>Date d'ajout</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Materiel> list = (ArrayList<Materiel>)request.getAttribute("materiels");
                        for (Materiel materiel : list) {
                    %>
                    <tr>
                        <td> <% out.println(materiel.getNom());%></td>
                        <td> <% out.println(materiel.getDate());%></td>
                        <td>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#supprimerMateriel<% out.print(materiel.getId_materiel());%>">Supprimer</button>
                            <!-- The Modal Book DELETE -->
                            <div class="modal fade" id="supprimerMateriel<% out.print(materiel.getId_materiel());%>">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal DELETE Header -->
                                        <div class="modal-header background-color-professeur">
                                            <h4 class="modal-title text-color-items">Supprimer un materiel</h4>
                                            <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal DELETE body -->
                                        <div class="modal-body text-center">
                                            <p>Etes-vous sûr de vouloir supprimer ce matériel : </p>
                                            <p><span style="font-weight: bold; font-size: 20px"><% out.print(materiel.getNom());%> </span>?</p>
                                        </div>

                                        <!-- Modal DELETE footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success mr-auto" data-dismiss="modal">Annuler</button>
                                            <form action="materiel" method="post">
                                                <input hidden type="text" name="id_materiel" value="<% out.print(materiel.getId_materiel());%>"/>
                                                <input type="submit" class="btn btn-danger" name="supprimerMateriel" value="Supprimer"/>
                                            </form>
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
    </div>
</body>
</html>
