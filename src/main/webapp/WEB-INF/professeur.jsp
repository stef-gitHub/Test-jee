<%@ page import="beans.Professeur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
    <nav class="background-color-professeur navbar navbar-expand-sm navbar-dark">
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
    <h1 class="display-3" style="text-align: center" >Gestion des professeurs</h1>
    <hr>
    <div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
        <div class="row">
            <div class="col-md-12">
                <br>
                <div class="float-right"> <!-- Button to Open the Modal -->
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#createProfesseur">Créer un professeur</button>

                    <!-- The Modal CREATE -->
                    <div class="modal fade" id="createProfesseur">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="professeur" method="post">
                                <!-- Modal Header -->
                                <div class="modal-header background-color-professeur">
                                    <h4 class="modal-title text-color-items">Création d'un professeur</h4>
                                    <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
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
                                        <input type="number" class="form-control" id="cpProfesseurCreate" name="cpProfesseurCreate" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="villeProfesseurCreate">Ville</label>
                                        <input type="text" class="form-control" id="villeProfesseurCreate" name="villeProfesseurCreate" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="mailProfesseurCreate">Adresse mail</label>
                                        <input type="email" class="form-control" id="mailProfesseurCreate" name="mailProfesseurCreate" >
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
                        <th><div style="text-align: center">Actions</div></th>
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
                            <div class="float-right">
                                <!-- Input Professor UPDATE -->
                                <input style="margin-right: 50px;" data-toggle="modal" data-target="#updateProfesseur" type="button" class="btn btn-warning" onclick="Modifier('<% out.print(professeur.getId_personne());%>', '<% out.print(professeur.getAdresse_mail());%>', '<% out.print(professeur.getAdresse());%>', '<% out.print(professeur.getCp());%>', '<% out.print(professeur.getVille());%>', '<% out.print(professeur.getNom());%>', '<% out.print(professeur.getPrenom());%>')" value="Modifier"/>
                                <!-- Delete Button -->
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#supprimerProf<% out.print(professeur.getId_personne());%>">Supprimer</button>
                                <!-- The Modal Professor DELETE -->
                                <div class="modal fade" id="supprimerProf<% out.print(professeur.getId_personne());%>">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- Modal DELETE Header -->
                                            <div class="modal-header background-color-professeur">
                                                <h4 class="modal-title text-color-items">Supprimer un professeur</h4>
                                                <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- Modal DELETE body -->
                                            <div class="modal-body text-center">
                                                <p>Etes-vous sûr de vouloir supprimer le professeur : </p>
                                                <p><span style="font-weight: bold; font-size: 20px"><% out.print(professeur.getPrenom());%> <% out.print(professeur.getNom());%> </span>? </p>
                                            </div>

                                            <!-- Modal DELETE footer -->
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-success mr-auto" data-dismiss="modal">Annuler</button>
                                                <form class="float-right" action="professeur" method="post">
                                                    <input hidden type="text" name="idProf" value="<% out.print(professeur.getId_personne());%>"/>
                                                    <input type="submit" class="btn btn-danger" name="supprimerProf" value="Supprimer"/>
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

        <!-- The Modal UPDATE -->
        <div class="modal fade" id="updateProfesseur">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header background-color-professeur">
                        <h4 class="modal-title text-color-items">Modifier un professeur</h4>
                        <button type="button" class="close text-color-items" data-dismiss="modal">&times;</button>
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
                                    <input type="number" class="form-control" id="cpProfesseurUpdate" name="cpProfesseurUpdate" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="villeProfesseurUpdate">Ville</label>
                                <input type="text" class="form-control" id="villeProfesseurUpdate" name="villeProfesseurUpdate" required>
                            </div>
                            <div class="form-group">
                                <label for="mailProfesseurUpdate">Adresse mail</label>
                                <input type="email" class="form-control" id="mailProfesseurUpdate" name="mailProfesseurUpdate">
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-warning" name="submit" value="Modifier"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    function Modifier(id, mail, adresse, cp, ville, nom, prenom){
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
