<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<h1>
    <%= "Exemplo JSTL" %>
</h1>
</br>
<div>
    <c:set var="salario" scope="session" value="${2000*2}" />

    <p>Valor do pagode é: <c:out value="${salario}" /></p>

    <c:catch var="e">
        <% int x = 5/0; %>
    </c:catch>
    <c:out value="${e.message}" />

    <c:if test="${e != null}">
        <c:out value="${e}" />
        <c:out value="${e.message}" />
    </c:if>
    
    <c:forTokens items="" delims=""

</div>
</body>
</html>