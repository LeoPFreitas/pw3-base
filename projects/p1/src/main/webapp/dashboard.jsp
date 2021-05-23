<%@ page import="co.lfreitas.p1.persistance.EmployeeDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="co.lfreitas.p1.entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mind
  Date: 23/05/2021
  Time: 11:52
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
    EmployeeDAO employeeDAO = new EmployeeDAO();
    List<Employee> employees = employeeDAO.getEmployees();
%>

<div id="app">
    <h4 class="head">Employees</h4>
    <div class="container">

        <table class="table-responsive bordered highlight centered hoverable z-depth-2">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Job Title</th>
            </tr>

            </thead>
            <tbody>
            <c:forEach var="employee" items="<%=employees%>">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.firstName}"/></td>
                    <td><c:out value="${employee.lastName}"/></td>
                    <td><c:out value="${employee.age}"/></td>
                    <td><c:out value="${employee.jobTitle}"/></td>
                    <td style="width: 18%;">
                        <a href="editEmployee.jsp?id=<c:out value="${employee.id}"/>"
                           class="btn waves-effect waves-light yellow darken-2"><i
                                class="material-icons">edit</i>
                        </a>
                        <a href="deleteEmployee?id=<c:out value="${employee.id}"/>"
                           class="btn waves-effect waves-light red darken-2"><i
                                class="material-icons">archive</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form method="post" action="addEmployee">
            <table class="table-responsive bordered highlight centered hoverable z-depth-2">
                <tr>
                    <td></td>
                    <td colspan="1">
                        <div class="input-field">
                            <input placeholder="Placeholder" name="firstName" id="firstName" type="text">
                            <label for="firstName">Fist Name</label>
                        </div>
                    </td>
                    <td colspan="1">
                        <div class="input-field">
                            <input placeholder="Placeholder" name="lastName" id="lastName" type="text">
                            <label for="lastName">Last Name</label>
                        </div>
                    </td>
                    <td>
                        <div class="input-field">
                            <input placeholder="Placeholder" id="age" name="age" type="text">
                            <label for="age">Age</label>
                        </div>
                    </td>
                    <td>
                        <div class="input-field">
                            <input placeholder="Placeholder" id="jobTitle" name="jobTitle" type="text">
                            <label for="jobTitle">Job</label>
                        </div>
                    </td>
                    <td style="text-align: center;">
                        <button type="submit" class="btn btn-waves green darken-2"><i
                                class="material-icons">add</i>
                        </button>
                </tr>
            </table>
        </form>
    </div>

</div>

<script src="script/script.js" type="text/javascript" rel="script"></script>
</body>
</html>
