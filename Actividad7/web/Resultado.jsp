<%-- 
    Document   : Resultado
    Created on : 01-mar-2021, 14:22:57
    Author     : Xan-T
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Suma" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <%
            Suma s = (Suma) request.getAttribute("sumaResuelta");
        %>
        
        <h1> Datos iniciales </h1>
        <h3> Base:  <%= s.getNum1() %> </h3>
        <h3> Altura:<%= s.getNum2() %> </h3> 
        <br>
        <br>
        <h1> Resultados </h1>
        <h3> Area: <%= s.getResultado() %></h3>
        <h3> Perimetro: <%= s.getPerimetro() %></h3> 
        
        <form action="index.jsp" method="post">
             <input type="submit" value="Nuevo Calculo">
         </form>
        
    </body>
</html>

