package org.example.iweb_lab6_20213745.daos;

import org.example.iweb_lab6_20213745.beans.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/mydb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ACTORS_BY_MOVIE =
            "SELECT a.* FROM Actor a JOIN PeliculaActor pa ON a.idActor = pa.idActor WHERE pa.idPelicula = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Actor> getActoresByPelicula(int idPelicula) {
        List<Actor> actores = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACTORS_BY_MOVIE)) {
            preparedStatement.setInt(1, idPelicula);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idActor = rs.getInt("idActor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int anoNacimiento = rs.getInt("anoNacimiento");
                boolean premioOscar = rs.getBoolean("premioOscar");
                actores.add(new Actor(idActor, nombre, apellido, anoNacimiento, premioOscar));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }
}


