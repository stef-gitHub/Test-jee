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
    <title>Title</title>
</head>
<body>
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
