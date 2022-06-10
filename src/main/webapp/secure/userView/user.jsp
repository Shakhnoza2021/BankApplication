<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <title>Личный кабинет</title>
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
            <tr>
                <td><a href="profile"><img class="profileImg" src = "<c:url value='/stylesheets/images/profile.png'/>"></a></td>
                <td><a href="profile" id="userName"><%out.println(request.getSession().getAttribute("name"));%></a></td>
                <td><a href="profile" id="profileTxt"> Профиль</a></td>
            </tr>
        </table>
        <form class="logoutForm" action="logout" method="get">
            <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
    </div>
    <div class="title">Добрый день, ${user.name}!</div><hr>
    <div>
        <table class="products">
            <tr><td class="menu"><a href="cards">Карты</a> </td></tr>
            <tr><td class="menu"><a href="credits">Кредиты</a> </td></tr>
            <tr><td class="menu"><a href="accounts">Счета</a> </td></tr>
        </table>
    </div>
</body>
</html>