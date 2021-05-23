package co.lfreitas.p1.servlet;

import co.lfreitas.p1.entity.Employee;
import co.lfreitas.p1.persistance.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addEmployee", value = "/addEmployee")
public class AddEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String jobTitle = request.getParameter("jobTitle");
        Employee employee = new Employee(firstName, lastName, age, jobTitle);

        EmployeeDAO dao = new EmployeeDAO();
        try {
            dao.addEmployee(employee);
            response.sendRedirect("dashboard.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            response.sendRedirect("error.jsp");
        }

    }
}