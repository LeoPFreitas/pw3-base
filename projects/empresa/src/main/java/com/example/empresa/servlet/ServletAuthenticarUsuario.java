package com.example.empresa.servlet;

import com.example.empresa.entity.Usuario;
import com.example.empresa.persistance.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletAutenticarUsuario", value = "/autenticar")
public class ServletAuthenticarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.authenticateUser(username, password);

        if (usuario != null) {
            session.setAttribute("usuario", usuario);
        }

        response.sendRedirect(".");
    }
}
