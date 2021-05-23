package co.lfreitas.p1.servlet;

import co.lfreitas.p1.entity.Employee;
import co.lfreitas.p1.persistance.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateEmployee", value = "/updateEmployee")
public class updateEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int age = Integer.parseInt(request.getParameter("age"));
            String jobTitle = request.getParameter("jobTitle");

            Employee employee = new Employee(firstName, lastName, age, jobTitle);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.updateById(id, employee);

            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

    }
}
