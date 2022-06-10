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

<div class="title">Редактирование</div><hr>

<div>
    <form method="get" action="findUser">
        <input name="phoneNum" id="phone" type="text" placeholder="Номер телефона">
        <input class="submitBtn" type="submit" value="Найти">
        <div><%
            request.setAttribute("client", request.getAttribute("client"));
        String err=(String)request.getAttribute("error");
        if(err!=null){
        System.out.println("login_msg --------- " + err);
        out.println("<font color=red size=2px>"+err+"</font>");}
        %>
        </div>
    </form>
    <div>
        <form>
            <div class="edit">
                <div class="title">Фамилия</div>
                <input id="lastName" name="lastName" type="text" placeholder="${client.lastName}">

                <div class="title">Имя</div>
                <input id="name" name="name" type="text" placeholder="${client.name}">

                <div class="title">Отчество</div>
                <input id="patronymic" name="patronymic" type="text" placeholder="${client.patronymic}">

                <div class="title">Телефон</div>
                <input id="phoneNum" name="phoneNum" type="text" placeholder="${client.phoneNum}">

                <div class="title">Email</div>
                <input id="email" name="email" type="text" placeholder="${client.email}">

                <div class="logoutBtn">
                    <a href="<c:url value='/secure/managerView/manager.jsp'/>">Отмена</a>
                    <input formaction="EditUser" formmethod="get" class="submitBtn" type="submit" value="Сохранить">
                    <input formaction="deleteUser" formmethod="get" class="submitBtn" type="submit" value="Удалить пользователя">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
