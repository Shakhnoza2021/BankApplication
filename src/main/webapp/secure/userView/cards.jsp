<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cards" class="java.util.ArrayList" scope="request"/>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <title>Карты</title>
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
            <td><a  href="profile"><img class="profileImg" src = "<c:url value='/stylesheets/images/profile.png'/>"></a></td>
            <td><a href="profile" id="userName"><%out.println(request.getSession().getAttribute("name"));%></a></td>
            <td><a href="profile" id="profileTxt"> Профиль</a></td>
        </tr>
    </table>
    <form class="logoutForm" action="logout" method="get">
        <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
</div>
<div class="title">Карты</div><hr>
<div class="tableOut">
    <table class="table">
        <tr>
            <th>Наименование</th>
            <th>Тип</th>
            <th>Сумма, руб.</th>
            <th>Процент, %</th>
            <th>Номер карты</th>
        </tr>

            <c:forEach items="${cards}" var="card">
        <tr>
                <td align="left">${card.name}</td>
                <td align="left">${card.type}</td>
                <td align="left">${card.sum}</td>
                <td align="center">${card.percent}</td>
                <td align="center">${card.cardNum}</td>
        </tr>
            </c:forEach>

    </table>
</div>
</body>
</html>