<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Connexion</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style =" background-color: #c47e7e2b;" >
<nav style="background-color: #9E2772" class="navbar navbar-expand-md navbar-dark ">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2"></div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto">Bienvenue sur votre application de gestion d'école</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2"></div>
</nav>
<div class="container" >
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Se connecter</h5>
                    <form class="form-signin" action="login" method="post">
                        <div class="form-label-group">
                            <label for="inputEmail">Identifiant</label>
                            <input type="text" id="inputEmail" class="form-control" name="login" placeholder="Identifiant" required autofocus>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <label for="inputPassword">Mot de passe</label>
                            <input type="password" id="inputPassword" class="form-control" name="mdp" placeholder="Mot de passe" required>
                        </div>
                        <hr>
                        <button class="btn btn-lg btn-success btn-block " type="submit">Connexion</button>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

