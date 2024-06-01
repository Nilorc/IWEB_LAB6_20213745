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
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaDao peliculaDao = new PeliculaDao();
        ArrayList<Pelicula> listaPeliculas = peliculaDao.listar();

        request.setAttribute("listaPeliculas", listaPeliculas);

        String vista = "listaPeliculas.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }
}
