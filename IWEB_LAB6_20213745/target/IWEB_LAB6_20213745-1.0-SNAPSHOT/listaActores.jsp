<%@ page import="org.example.iweb_lab6_20213745.beans.Actor" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.iweb_lab6_20213745.beans.Pelicula" %>
<%@ page import="org.example.iweb_lab6_20213745.beans.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
    List<Actor> actores = (List<Actor>) request.getAttribute("actores");
%>
<html>

    <body>
        <h1><td><%= pelicula.getTitulo() %></td></h1>
        <table border="1">
            <tr>
                <th>idActor</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Año Nacimiento</th>
                <th>Ganador Premio Oscar</th>
            </tr>
            <%
                if (actores != null) {
                    for (Actor actor : actores) {
            %>
            <tr>
                <td><%= actor.getIdActor() %></td>
                <td><%= actor.getNombre() %></td>
                <td><%= actor.getApellido() %></td>
                <td><%= actor.getAnoNacimiento() %></td>
                <td><%= actor.isPremioOscar() %></td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
