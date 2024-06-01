package org.example.iweb_lab6_20213745.daos;

import org.example.iweb_lab6_20213745.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao {
    public ArrayList<Pelicula> listar() {
        ArrayList<Pelicula> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, " +
                "CONCAT('$', FORMAT(p.boxOffice, 0)) AS boxOffice, g.nombre as genero " +
                "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero " +
                "ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getString("boxOffice"));  // Cambiado a String
                pelicula.setGenero(rs.getString("genero"));
                lista.add(pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Pelicula obtenerPorId(int idPelicula) {
        Pelicula pelicula = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, " +
                "CONCAT('$', FORMAT(p.boxOffice, 0)) AS boxOffice, g.nombre as genero " +
                "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero " +
                "WHERE p.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Pelicula();
                    pelicula.setIdPelicula(rs.getInt("idPelicula"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                    pelicula.setRating(rs.getDouble("rating"));
                    pelicula.setBoxOffice(rs.getString("boxOffice"));
                    pelicula.setGenero(rs.getString("genero"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }
}
