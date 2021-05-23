package co.lfreitas.p1.servlet;

import co.lfreitas.p1.entity.Users;
import co.lfreitas.p1.persistance.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();


        UserDAO dao = new UserDAO();
        Optional<Users> user = dao.authenticateUser(username, password);

        user.ifPresentOrElse(u -> {
            if (u.getPassword().equals(password)) {
                session.setAttribute("user", u);
                try {
                    resp.sendRedirect("dashboard.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.println("Senha inválida");
                    resp.sendRedirect(".");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, () -> {
            try {
                resp.sendRedirect("error.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}