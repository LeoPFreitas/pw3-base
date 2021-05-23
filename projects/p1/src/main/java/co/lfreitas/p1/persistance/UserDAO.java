package co.lfreitas.p1.persistance;

import co.lfreitas.p1.utils.DatabaseConnection;
import co.lfreitas.p1.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {
    public void insertUser(Users usuario) throws SQLException, ClassNotFoundException {
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "INSERT INTO users(name, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getPassword());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Optional<Users> authenticateUser(String username, String password) {
        Users usuario = null;
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                usuario = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(usuario);
    }
}

