<%-- 
    Document   : index
    Created on : 23-mar-2021, 13:29:06
    Author     : Xan-T
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.Controlador" %>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesiones y cookies</title>
    </head>
    <body>
        
       
        
        
        <%
            Cookie ck[] = request.getCookies();
            if(ck!=null){
                out.print("Triangulo anterior: ");
                for(int i = 0; i<ck.length; i++){
                    if(ck[i].getName().equals("Base")){
                        out.print("Base: "+ck[i].getValue()+ ", Altura: ");
                    }
                    if(ck[i].getName().equals("Altura")){
                        out.print(ck[i].getValue()+", Area: ");
                    }
                    if(ck[i].getName().equals("Area")){
                        out.print(ck[i].getValue()+", Perimetro: ");
                    }
                    if(ck[i].getName().equals("Perimetro")){
                        out.print(ck[i].getValue());
                    }
                    
                }
            }
         %>
         <br>
         <br>
          <%
            HttpSession sesion = request.getSession(false);
            Enumeration e = sesion.getAttributeNames();
            if(e.hasMoreElements()){
                out.print("Hola " + session.getAttribute("Username") + ", es una alegria verte de nuevo");
            }
            else{
                out.print("Cual es su nombre?");
            }
            
        %>
        
        <% 
        if(request.getAttribute("Error") != null){
            out.print("<h1>Favor de usar números mayores a 0.</h1>");
        }
    %>
        
        
         <form action="Controlador" method="post">
             Nombre: <br>
             <input type="text" name="Username" value="<%= session.getAttribute("Username")%>"><br>
             Numero 1: <br>
             <input type="text" name="Base" value=""><br>
             Numero 2: <br>
             <input type="text" name="Altura" value=""><br>
             <input type="submit" value="Calcular">
         </form>
    </body>
</html>
