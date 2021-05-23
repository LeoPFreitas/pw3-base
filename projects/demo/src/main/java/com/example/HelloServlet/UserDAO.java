package com.example.HelloServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class UserDAO {
    public ArrayList<Users> getUsers() {
        ArrayList<Users> lista = new ArrayList<Users>();
        String nome, email, password;
        int id;

        try {
            //Inicializa a database
            Connection con = DatabaseConnection.initializeDatabase();

            //cria a statement
            Statement stmt = con.createStatement();
            ResultSet rs;

            //cria a consulta
            rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                id = rs.getInt("id");
                nome = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                lista.add(new Users(id, nome, email, password));
            }

            //fechar as conexões
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Optional<Users> getUser(String email) {
        try {
            //Inicializa a database
            Connection con = DatabaseConnection.initializeDatabase();

            //cria a statement
            Statement stmt = con.createStatement();
            ResultSet rs;

            //cria a consulta
            rs = stmt.executeQuery("SELECT * FROM users WHERE users.email = " + email);

            Optional<Users> usersOptional = Optional.of(rs.getObject(1, Users.class));

            //fechar as conexões
            stmt.close();
            con.close();
            return usersOptional;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


    //Insere um elemento na DB
    public void addUser(String nome, String email, String password) {
        try {
            //Inicializar a database
            Connection con = DatabaseConnection.initializeDatabase();

            //Criar um SQL
            PreparedStatement st = con.prepareStatement("INSERT INTO users(name,email,password) VALUES(?,?,?)");

            //Configurar os parâmetros do statement
            st.setString(1, nome);
            st.setString(2, email);
            st.setString(3, password);

            //Execução que modifica a database
            st.executeUpdate();

            //fechar as conexões
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
