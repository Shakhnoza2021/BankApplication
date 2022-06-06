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
            <a class="topMenuBtn" href="<c:url value='/secure/userView/payments.jsp'/>">Платежи и переводы</a>
            <a class="topMenuBtn" href="<c:url value='/secure/userView/operations.jsp'/>">История</a>
            <a class="topMenuBtn" href="<c:url value='/secure/userView/catalog.jsp'/>">Все продукты</a>
        </div>

        <table class="profileTable">
            <tr>
                <td><a  href="<c:url value='/secure/userView/profile.jsp'/>"><img class="profileImg" src = "<c:url value='/stylesheets/images/profile.png'/>"></a></td>
                <td><a href="<c:url value='/secure/userView/profile.jsp'/>" id="userName"><%out.println(request.getSession().getAttribute("name"));%></a></td>
                <td><a href="<c:url value='/secure/userView/profile.jsp'/>" id="profileTxt"> Профиль</a></td>
            </tr>
        </table>
        <form class="logoutForm" action="logout" method="get">
            <button class="logoutBtn" type="submit" value="logout"> Выход </button></form>
    </div>
<div>
    <table class="products">
        <tr><td><a href="cards">Карты</a> </td></tr>
        <tr><td><a href="credits">Кредиты</a> </td></tr>
        <tr><td><a href="accounts">Счета</a> </td></tr>
    </table>


</div>

</body>
</html>