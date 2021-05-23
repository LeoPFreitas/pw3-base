<%--
  Created by IntelliJ IDEA.
  User: mind
  Date: 26/04/2021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="lib/css/style.css">
</head>
<body>
<div id="area">
    <form autocomplete='off' class='form' action="login" method="post">
        <div class='control'>
            <h1>
                Login
            </h1>
        </div>
        <div class='control block-cube block-input'>
            <label aria-hidden="true" for="email">Nome:</label>
            <input id="email" name="email" placeholder='E-mail' type='email'>
            <div class='bg-top'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg-right'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg'>
                <div class='bg-inner'></div>
            </div>
        </div>
        <div class='control block-cube block-input'>
            <label aria-hidden="true" for="password">Password:</label>
            <input id="password" name="password" placeholder='Password' type='password'>
            <div class='bg-top'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg-right'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg'>
                <div class='bg-inner'></div>
            </div>
        </div>
        <button class='btn block-cube block-cube-hover' type='submit'>
            <div class='bg-top'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg-right'>
                <div class='bg-inner'></div>
            </div>
            <div class='bg'>
                <div class='bg-inner'></div>
            </div>
            <div class='text'>
                Enviar
            </div>
        </button>
    </form>
</div>
</body>
</html>
