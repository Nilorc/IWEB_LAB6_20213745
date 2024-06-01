package org.example.iweb_lab6_20213745.servlets;

import org.example.iweb_lab6_20213745.beans.Actor;
import org.example.iweb_lab6_20213745.beans.Pelicula;
import org.example.iweb_lab6_20213745.daos.ActorDao;
import org.example.iweb_lab6_20213745.daos.PeliculaDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ActoresServlet", value = "/ActoresServlet")
public class ActoresServlet extends HttpServlet {
    private ActorDao actorDao;
    private PeliculaDao peliculaDao;

    public void init() {
        actorDao = new ActorDao();
        peliculaDao = new PeliculaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPeliculaStr = request.getParameter("idPelicula");

        int idPelicula = Integer.parseInt(idPeliculaStr);
        List<Actor> actores = actorDao.getActoresByPelicula(idPelicula);
        Pelicula pelicula = peliculaDao.obtenerPorId(idPelicula);

        String vista = "listaActores.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }
}