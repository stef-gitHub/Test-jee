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
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">Logo</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">Professeurs</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Elèves</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Classes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Emprunts</a>
        </li>
    </ul>
</nav>
<p>Ceci est une page générée depuis une JSP.</p>
<p>
    <%
        String attribut = (String) request.getAttribute("test");
        out.println( attribut );

        beans.Personne notreBean = (beans.Personne) request.getAttribute("personne");
        out.println( notreBean.getPrenom() );
        out.println( notreBean.getNom() );
    %>
<form action="/tirage" method="post">
    <%
        for(int i = 1; i < 3; i++){
            out.println("Numéro " + i + ": <select name=\"number"+i+"\">");
            for(int j = 1; j <= 10; j++){
                out.println("<option value=\""+j+"\">"+ j + "</option>");
            }
            out.println("</select><br />");
        }
    %>
    <br />
    <input type="submit" value="Valider" />
</form>

</p>
</body>
</html>
