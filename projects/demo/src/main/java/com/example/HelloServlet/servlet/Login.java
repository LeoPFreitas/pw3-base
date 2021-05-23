package com.example.HelloServlet.servlet;

import com.example.HelloServlet.UserDAO;
import com.example.HelloServlet.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();
        Optional<Users> user = dao.getUser(email);

        user.ifPresentOrElse(u -> {
            if (u.getPassword().equals(password)) {
                System.out.println("Login ok");
            } else {
                System.out.println("Senha invalida");
            }
        }, () -> System.out.println("deu merda"));


    }
}
