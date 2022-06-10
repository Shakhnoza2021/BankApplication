<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="accounts" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="operations" class="java.util.ArrayList" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/checkParams.js'/>"></script>
    <title>История операций</title>
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
<div class="title">Счета</div><hr>
<div class="tableOut">
    <table class="table">
        <tr>
            <th>Наименование</th>
            <th>Сумма, руб.</th>
            <th>Номер счета</th>
        </tr>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td align="left">${account.name}</td>
                <td align="left">${account.sum}</td>
                <td align="left">${account.accountNum}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="title">История операций</div>
<div>
    <form action="history" method="get">
        <select id="account" class="options" name="account">
            <option selected="selected" disabled label="Счёт" value="1">-- Счёт --</option>
            <c:forEach items="${accounts}" var="account">
                <option>${account.accountNum}</option>
            </c:forEach>
        </select>
        <input class="submitBtn" type="submit" value="Открыть">
    </form>
</div>

<div class="tableOut">
    <table class="table">
        <tr>
            <th>Наименование</th>
            <th>Тип</th>
            <th>Сумма, руб.</th>
            <th>Номер счета</th>
            <th>Дата</th>
        </tr>
        <c:forEach items="${operations}" var="op">
            <tr>
                <td align="left">${op.name}</td>
                <td align="left">${op.type}</td>
                <td align="left">${op.sum}</td>
                <td align="left">${op.accNum}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>