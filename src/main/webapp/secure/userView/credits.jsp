<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="credits" class="java.util.ArrayList" scope="request"/>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <title>Кредиты</title>
</head>
<body>
<div class="head">
    <a href="<c:url value='/secure/userView/user.jsp'/>" class="logo">НСК Банк</a>
    <div class="topMenu">
        <a class="topMenuBtn" href="<c:url value='/secure/userView/user.jsp'/>">Главная</a>
        <a class="topMenuBtn" href="<c:url value='/secure/userView/payments.jsp'/>">Платежи и переводы</a>
        <a class="topMenuBtn" href="<c:url value='/secure/userView/operations.jsp'/>">История</a>
        <a class="topMenuBtn" href="<c:url value='/secure/userView/catalog.jsp'/>">Все продукты</a>
    </div>

    <table class="profileTable">
        <tr class="profileLine">
            <td><a  href="<c:url value='/secure/userView/profile.jsp'/>"><img class="profileImg" src = "<c:url value='/stylesheets/images/profile.png'/>"></a></td>
            <td><a href="<c:url value='/secure/userView/profile.jsp'/>" id="userName"><%out.println(request.getSession().getAttribute("name"));%></a></td>
            <td><a href="<c:url value='/secure/userView/profile.jsp'/>" id="profileTxt"> Профиль</a></td>
        </tr>
    </table>
    <form class="logoutForm" action="logout" method="get">
        <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
</div>
<div class="title">Кредиты</div><hr>
<div class="tableOut">
    <table class="table">
        <tr>
            <th>Наименование</th>
            <th>Сумма, руб.</th>
            <th>Срок, мес.</th>
            <th>Процент, %</th>
            <th>Регулярный платеж, руб.</th>
            <th>Всего внесено, руб.</th>
            <th>Осталось внести, руб.</th>
        </tr>

        <c:forEach items="${credits}" var="credit">
        <tr>
            <td align="left">${credit.name}</td>
            <td align="left">${credit.sum}</td>
            <td align="left">${credit.term}</td>
            <td align="center">${credit.percent}</td>
            <td align="center">${credit.monthlyPayment}</td>
            <td align="center">${credit.totalPayed}</td>
            <td align="left">${credit.remainsToPay}</td>
        </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
