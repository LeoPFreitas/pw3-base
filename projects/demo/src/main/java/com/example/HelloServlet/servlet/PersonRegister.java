package com.example.HelloServlet.servlet;

import com.example.HelloServlet.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class PersonRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        dao.addUser(nome, email, password);

        request.getSession().setAttribute("lista", dao.getUsers());

        //response.sendRedirect("mostrarDados.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarDados.jsp");
        dispatcher.forward(request, response);

    }
}
