package com.example.empresa.servlet;

import com.example.empresa.entity.Usuario;
import com.example.empresa.persistance.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCadastrarUsuario", value = "/cadastrar-usuario")
public class ServletCadastrarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario(nome, email, cpf, username, password);

        UsuarioDAO dao = new UsuarioDAO();

        try {
            dao.insertUsuer(usuario);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect(".");
    }
}
