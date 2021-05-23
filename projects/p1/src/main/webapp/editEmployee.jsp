<%@ page import="co.lfreitas.p1.persistance.EmployeeDAO" %>
<%@ page import="co.lfreitas.p1.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: mind
  Date: 23/05/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.10/vue.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    int employeeId = Integer.parseInt(request.getParameter("id"));
    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee employee = employeeDAO.getEmployeeById(employeeId);

%>

<div id="app">
    <h4 class="head">Update Employee</h4>
    <div class="container">
        <form method="post" action="updateEmployee">
            <table class="table-responsive bordered highlight centered hoverable z-depth-2">
                <input hidden name="id" id="id" value="<%=employeeId%>"/>
                <tr>
                    <td></td>
                    <td colspan="1">
                        <div class="input-field">
                            <input placeholder="Placeholder" name="firstName" id="firstName" type="text"
                                   value="<%=employee.getFirstName()%>">
                            <label for="firstName">Fist Name</label>
                        </div>
                    </td>
                    <td colspan="1">
                        <div class="input-field">
                            <input placeholder="Placeholder" name="lastName" id="lastName" type="text"
                                   value="<%=employee.getLastName()%>">
                            <label for="lastName">Last Name</label>
                        </div>
                    </td>
                    <td>
                        <div class="input-field">
                            <input placeholder="Placeholder" id="age" name="age" type="text"
                                   value="<%=employee.getAge()%>">
                            <label for="age">Age</label>
                        </div>
                    </td>
                    <td>
                        <div class="input-field">
                            <input placeholder="Placeholder" id="jobTitle" name="jobTitle" type="text"
                                   value="<%=employee.getJobTitle()%>">
                            <label for="jobTitle">Job</label>
                        </div>
                    </td>
                    <td style="text-align: center;">
                        <button type="submit" class="btn btn-waves green darken-2"><i
                                class="material-icons">update</i>
                        </button>
                </tr>
            </table>
        </form>
    </div>

</div>


</body>
</html>
