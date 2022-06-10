<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="model.User" scope="session"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/manager.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/checkParams.js'/>"></script>
    <title>Менеджер</title>
</head>
<body>
<div class="head">
    <a href="<c:url value='/secure/managerView/manager.jsp'/>" class="logo">НСК Банк</a>
    <form class="logoutForm" action="logout" method="get">
        <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
</div>

<div class="title">Добрый день, ${user.name}!</div><hr>

<div>
    <table>
        <tr><td class="menu"><a class="text" href="creditApp">Заявки по кредитам</a> </td></tr>
        <tr><td class="menu"><a class="text" href="cardApp">Заявки на заведение/закрытие банковских карт</a> </td></tr>
        <tr><td class="menu"><a class="text" href="editUser">Редактирование клиентов</a> </td></tr>
    </table>

</div>
</body>
</html>
