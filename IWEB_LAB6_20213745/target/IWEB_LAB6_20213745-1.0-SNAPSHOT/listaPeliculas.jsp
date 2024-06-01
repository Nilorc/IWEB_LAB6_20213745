<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.iweb_lab6_20213745.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) request.getAttribute("listaPeliculas");
%>
<html>
    <head>
        <title>Películas</title>
    </head>
    <body>
        <h1>Lista de Películas</h1>
        <form action="PeliculaServlet" method="get">
            <input type="text" name="busqueda" placeholder="Buscar...">
            <button type="submit">Buscar</button>
        </form>
        <table border="1">
            <tr>
                <th>Título</th>
                <th>Director</th>
                <th>Año de Publicación</th>
                <th>Rating</th>
                <th>Box Office</th>
                <th>Género</th>
                <th>Actores</th>
            </tr>
            <% for (Pelicula pelicula : listaPeliculas) { %>
            <tr>
                <td><a href="DetallesServlet?idPelicula=<%= pelicula.getIdPelicula() %>"><%= pelicula.getTitulo() %></a></td>
                <td><%= pelicula.getDirector() %></td>
                <td><%= pelicula.getAnoPublicacion() %></td>
                <td><%= pelicula.getRating() %></td>
                <td><%= pelicula.getBoxOffice() %></td>
                <td><%= pelicula.getGenero() %></td>
                <td><a href="ActoresServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
