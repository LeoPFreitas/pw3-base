package co.lfreitas.p1.persistance;

import co.lfreitas.p1.entity.Employee;
import co.lfreitas.p1.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "INSERT INTO employee(firstName, lastName, age, jobTitle) VALUES (?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getJobTitle());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "SELECT * FROM employee;";

            PreparedStatement stmt = con.prepareStatement(sql);
            try {
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getInt("age"),
                            resultSet.getString("jobTitle")
                    );
                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void removeById(int id) {
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "DELETE FROM employee WHERE id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);

            try {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "SELECT * FROM employee WHERE id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);


            try {
                stmt.setInt(1, employeeId);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    employee = new Employee(
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getInt("age"),
                            resultSet.getString("jobTitle")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void updateById(int id, Employee employee) {
        try (Connection con = DatabaseConnection.initializeDatabase()) {
            String sql = "UPDATE employee SET firstName = ?, lastName = ?, age = ?, jobTitle = ? where id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, String.valueOf(employee.getAge()));
            stmt.setString(4, employee.getJobTitle());
            stmt.setInt(5, id);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
