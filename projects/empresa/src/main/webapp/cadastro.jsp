<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
    <div id="area">
        <h2>Cadastro de Usuário</h2>
        <form action="cadastrar-usuario" method="post">
            <label for="nome">Nome</label>
            <input type="text" placeholder="Entre com o nome" name="nome" id="nome" required>

            <label for="email">E-mail</label>
            <input type="text" placeholder="Entre com o e-mail" name="email" id="email" required>

            <label for="cpf">CPF</label>
            <input type="text" placeholder="Entre com o CPF" name="cpf" id="cpf" required>

            <label for="username">Usuário</label>
            <input type="text" placeholder="Entre com o Usuario" name="username" id="username" required>

            <label for="password">Senha</label>
            <input type="password" placeholder="Entre com a senha" name="password" id="password" required>

            <button type="submit">Cadastrar</button>
        </form>
    </div>

</body>
</html>
