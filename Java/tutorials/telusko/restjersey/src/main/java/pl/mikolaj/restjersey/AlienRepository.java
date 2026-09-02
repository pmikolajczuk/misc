package pl.mikolaj.restjersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlienRepository {
    private Connection conn = null;
    private static final Logger LOGGER = Logger.getLogger(AlienRepository.class.getName());

    public AlienRepository() {
        String url = "jdbc:mysql://localhost:3306/restdb";
        String username = "root";
        String password = "haswo";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "JDBC Driver not found", e);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to establish DB connection", e);
        }
    }

    public List<Alien> getAliens() {
        String sql = "SELECT * FROM alien";
        List<Alien> aliens = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                aliens.add(mapRowToAlien(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching aliens", e);
        }
        return aliens;
    }

    public Alien getAlien(int id) {
        String query = "SELECT * FROM alien WHERE id = ?";
        Alien alien = null;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    alien = mapRowToAlien(resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching alien by id: " + id, e);
        }
        return alien;
    }

    public void create(Alien alien) {
        String sql = "INSERT INTO alien VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, alien.getId());
            preparedStatement.setString(2, alien.getName());
            preparedStatement.setInt(3, alien.getPoints());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error creating alien", e);
        }
    }

    public void update(Alien alien) {
        String sql = "UPDATE alien SET name = ?, points = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, alien.getName());
            preparedStatement.setInt(2, alien.getPoints());
            preparedStatement.setInt(3, alien.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating alien", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM alien WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting alien with id: " + id, e);
        }
    }

    private Alien mapRowToAlien(ResultSet rs) throws SQLException {
        Alien alien = new Alien();
        alien.setId(rs.getInt("id"));
        alien.setName(rs.getString("name"));
        alien.setPoints(rs.getInt("points"));
        return alien;
    }
}
