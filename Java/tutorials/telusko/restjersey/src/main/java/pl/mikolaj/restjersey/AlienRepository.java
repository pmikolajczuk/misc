package pl.mikolaj.restjersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
    Connection conn = null;

    public AlienRepository() {
        String url = "jdbc:mysql://localhost:3306/restdb";
        String username = "root";
        String password = "haswo";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alien> getAliens() {
        String sql = "SELECT * FROM alien";
        List<Alien> aliens = new ArrayList<>();
        try {
            var statement = conn.createStatement();
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Alien alien = new Alien();
                alien.setId(resultSet.getInt("id"));
                alien.setName(resultSet.getString("name"));
                alien.setPoints(resultSet.getInt("points"));
                aliens.add(alien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aliens;
    }

    public Alien getAlien(int id) {
        String sql = "SELECT * FROM alien WHERE id = " + id;
        Alien alien = null;
        try {
            var statement = conn.createStatement();
            var resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                alien = new Alien();
                alien.setId(resultSet.getInt("id"));
                alien.setName(resultSet.getString("name"));
                alien.setPoints(resultSet.getInt("points"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alien;
    }

    public void create(Alien alien) {
        String sql = "INSERT INTO alien VALUES (?, ?, ?)";
        try {
            var preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, alien.getId());
            preparedStatement.setString(2, alien.getName());
            preparedStatement.setInt(3, alien.getPoints());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Alien alien) {
        String sql = "UPDATE alien SET name = ?, points = ? WHERE id = ?";
        try {
            var preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, alien.getName());
            preparedStatement.setInt(2, alien.getPoints());
            preparedStatement.setInt(3, alien.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM alien WHERE id = ?";
        try {
            var preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
