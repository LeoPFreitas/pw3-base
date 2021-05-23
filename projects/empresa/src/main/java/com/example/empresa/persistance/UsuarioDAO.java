package com.example.empresa.persistance;

import com.example.empresa.entity.Usuario;
import com.example.empresa.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void insertUsuer(Usuario usuario) throws SQLException, ClassNotFoundException {
        try (Connection con = DatabaseConnection.initializeConnection()) {
            String sql = "INSERT INTO users(name, email, cpf, username, password) VALUES (?, ?, ?, ?, MD5(?))";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getUsername());
            stmt.setString(5, usuario.getPassword());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Usuario authenticateUser(String username, String password) {
        Usuario usuario = null;
        try (Connection con = DatabaseConnection.initializeConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = MD5(?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("cpf"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
