<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="accounts" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="operations" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="user" class="model.User" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/checkParams.js'/>"></script>
    <title>Редактирование</title>
</head>
<body>
<div class="head">
    <a href="<c:url value='/secure/userView/user.jsp'/>" class="logo">НСК Банк</a>
    <div class="topMenu">
        <a class="topMenuBtn" href="<c:url value='/secure/userView/user.jsp'/>">Главная</a>
        <a class="topMenuBtn" href="payments">Платежи</a>
        <a class="topMenuBtn" href="transferTo">Переводы</a>
        <a class="topMenuBtn" href="history">История</a>
        <a class="topMenuBtn" href="<c:url value='/secure/userView/catalog.jsp'/>">Все продукты</a>
    </div>

    <table class="profileTable">
        <tr class="profileLine">
            <td><a href="profile"><img class="profileImg" src = "<c:url value='/stylesheets/images/profile.png'/>"></a></td>
            <td><a href="profile" id="userName"><%out.println(request.getSession().getAttribute("name"));%></a></td>
            <td><a href="profile" id="profileTxt"> Профиль</a></td>
        </tr>
    </table>
    <form class="logoutForm" action="logout" method="get">
        <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
</div>

<div class="title">Редактирование</div><hr>
<form action="saveEdit" method="get">
    <div class="edit">
        <div class="title">Фамилия</div>
        <input id="lastName" name="lastName" type="text" placeholder="${user.lastName}">

        <div class="title">Имя</div>
        <input id="name" name="name" type="text" placeholder="${user.name}">

        <div class="title">Отчество</div>
        <input id="patronymic" name="patronymic" type="text" placeholder="${user.patronymic}">

        <div class="title">Телефон</div>
        <input id="phoneNum" name="phoneNum" type="text" placeholder="${user.phoneNum}">

        <div class="title">Email</div>
        <input id="email" name="email" type="text" placeholder="${user.email}">

        <div class="logoutBtn">
            <a href="profile">Отмена</a>
            <input class="submitBtn" type="submit" value="Сохранить">
        </div>
    </div>
</form>
</body>
</html>
