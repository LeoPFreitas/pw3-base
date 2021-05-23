<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.example.HelloServlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Endereços Cadastrados</title>
</head>
<body>
<h1>Contatos Cadastrados</h1>

<% ArrayList<Users> lista = (ArrayList<Users>) request.getSession().getAttribute("lista"); %>

<table>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Password</th>
    </tr>

    <% for (int i = 0; i< lista.size(); i++) { %>

    <tr>
        <td><%= lista.get(i).getId()%></td>
        <td><%= lista.get(i).getEmail()%></td>
        <td><%= lista.get(i).getPassword()%></td>
    </tr>
    <% } %>
</table>

</body>
</html>
