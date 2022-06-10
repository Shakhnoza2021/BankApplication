<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="model.User" scope="session"/>
<jsp:useBean id="client" class="model.User" scope="request"/>

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

<div class="title">Добавление</div><hr>

<div>
        <form>
            <div class="edit">
                <div class="title">Фамилия</div>
                <input id="lastName" name="lastName" type="text">

                <div class="title">Имя</div>
                <input id="name" name="name" type="text">

                <div class="title">Отчество</div>
                <input id="patronymic" name="patronymic" type="text">

                <div class="title">Телефон</div>
                <input id="phoneNum" name="phoneNum" type="text">

                <div class="title">Email</div>
                <input id="email" name="email" type="text">

                <div class="logoutBtn">
                    <a href="<c:url value='/secure/managerView/manager.jsp'/>">Отмена</a>
                    <input formaction="addUser" formmethod="get" class="submitBtn" type="submit" value="Сохранить">
                </div>
            </div>
        </form>
</div>
</body>
</html>
