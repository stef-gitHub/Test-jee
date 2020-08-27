<%--
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
    <nav style="background-color : #9E2772" class="navbar navbar-expand-sm navbar-dark">
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
    <div style="text-align: center"><h1 style="font-size: 80px; font-family: Lucida Console, Courier, monospace; ">Tableau de bord</h1></div>
    <div style ="background-color: white;margin-top: 50px; max-width: 80%" class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 style="text-align: center">Les professeurs</h2>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
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
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
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
                    <h3>Nombre d'élèves :</h3>
                    <h3>Nombre de professeurs :</h3>
                    <h3>Total :</h3>
                    <br>
                </div>
            </div>
            <div class="col-md-6 ">
                <div style="background-color: #FFA24F; border-radius: 10px" class="col-md-12">
                    <h2 style="text-align: center">Emprunts</h2>
                    </br>
                    <h3>Emprunts mois en cours :</h3>
                    <h3> Nombre d'emprunteurs :</h3>
                    <h3>Total :</h3>
                    <br>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
