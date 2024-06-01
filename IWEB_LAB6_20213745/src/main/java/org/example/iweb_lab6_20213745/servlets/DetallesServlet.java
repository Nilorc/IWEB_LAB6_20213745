package org.example.iweb_lab6_20213745.servlets;

import org.example.iweb_lab6_20213745.beans.Pelicula;
import org.example.iweb_lab6_20213745.daos.PeliculaDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        PeliculaDao peliculaDao = new PeliculaDao();
        Pelicula pelicula = peliculaDao.obtenerPorId(idPelicula);

        request.setAttribute("pelicula", pelicula);

        String vista = "viewPelicula.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }
}
