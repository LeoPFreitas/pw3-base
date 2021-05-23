<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.empresa.entity.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login no Sistema da Empresa</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null) {
        session.removeAttribute("usuario");
%>
<h1>Bem Vindo <%=usuario.getNome()%>!!!</h1>
<%
    }
%>
    <div id="area">
        <h2>Login</h2>
        <form method="post" action="autenticar">
            <div class="imgcontainer">
                <img src="https://via.placeholder.com/150" alt="placeholder">
            </div>
            <div class="container">
                <label for="username">Username</label>
                <input type="text" placeholder="Entre com o usuário" name="username" id="username">

                <label for="password">Password</label>
                <input type="password" placeholder="Entre com a senha" name="password" id="password">

                <button type="submit">Login</button>

                <label>
                    <input type="checkbox" checked="checked" name="lembrar"> Lembrar
                </label>
            </div>
            <div class="container" style="background-color: #f1f1f1">
                <button class="cancelbtn" type="button">Cancelar</button>
                <span class="novousuario">Cadastro <a href="${pageContext.request.contextPath}/cadastro.jsp">Novo Usuário</a></span>
            </div>
        </form>
    </div>

<br/>
</body>
</html>