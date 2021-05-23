package co.lfreitas.p1.servlet;

import co.lfreitas.p1.entity.Users;
import co.lfreitas.p1.persistance.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users = new Users(nome, username, password);

        UserDAO dao = new UserDAO();
        try {
            dao.insertUser(users);
            response.sendRedirect("login.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            response.sendRedirect("error.jsp");
        }

    }
}
