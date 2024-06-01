<%@ page import="org.example.iweb_lab6_20213745.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
%>
<html>
    <head>
        <title>Detalles</title>
    </head>
    <body>
        <h1>Detalles de la Película</h1>
        <table border="1">
            <tr>
                <th>Título</th>
                <td><%= pelicula.getTitulo() %></td>
            </tr>
            <tr>
                <th>Director</th>
                <td><%= pelicula.getDirector() %></td>
            </tr>
            <tr>
                <th>Año de Publicación</th>
                <td><%= pelicula.getAnoPublicacion() %></td>
            </tr>
            <tr>
                <th>Rating</th>
                <td><%= pelicula.getRating() %></td>
            </tr>
            <tr>
                <th>Box Office</th>
                <td><%= pelicula.getBoxOffice() %></td>
            </tr>
            <tr>
                <th>Género</th>
                <td><%= pelicula.getGenero() %></td>
            </tr>
            <tr>
                <th>Actores</th>
                <td><a href="ActoresServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
            </tr>
        </table>



    </body>
</html>
