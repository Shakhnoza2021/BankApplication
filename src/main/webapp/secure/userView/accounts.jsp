<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="accounts" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="cards" class="java.util.ArrayList" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/checkParams.js'/>"></script>
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
<div class="title">Оплата услуг</div>
    <form action="" method="post" id="payForm">
        <select class="options" onchange="showElem('container1', this.value)">
            <option selected="selected" disabled label="Услуга" value="1">-- Выберите услугу --</option>
            <option value="phone">Телефонная связь</option>
            <option value="fine">Штрафы</option>
            <option value="comServ">ЖКХ</option>
        </select>
    </form>
</div>

<div id="container1">
    <div id="phone">
        <select class="provider">
            <option selected="selected" disabled label="Оператор" value="1">-- Сотовый оператор --</option>
            <option>Мегафон</option>
            <option>МСТ</option>
            <option>Билайн</option>
        </select>
        <input type="text" placeholder="Номер телефона">
        <input type="text" placeholder="Сумма">
        <input class="submitBtn" type="submit" value="Отправить">
    </div>
    <div id="fine">
        <select class="company">
            <option selected="selected" disabled label="Организация" value="1">-- Организация --</option>
            <option>Штрафы (ГИБДД, МВД)</option>
            <option>Администрация</option>
            <option>ФССП(судебные)</option>
        </select>
        <input type="text" placeholder="Номер документа">
        <input type="text" placeholder="Сумма">
        <input class="submitBtn" type="submit" value="Отправить">
    </div>
    <div id="comServ">
        <select class="type">
            <option selected="selected" disabled label="Название ЖКУ" value="1">-- Название ЖКУ --</option>
            <option>Электроэнергия</option>
            <option>Холодная вода</option>
            <option>Горячая вода</option>
            <option>Отопление</option>
            <option>Вывоз мусора</option>
        </select>
        <select class="company">
            <option selected="selected" disabled label="Организация" value="1">-- Организация --</option>
            <option>НСК РТС</option>
            <option>Водоканал</option>
            <option>УК Гарант</option>
        </select>
        <input type="text" placeholder="Личный кабинет">
        <input type="text" placeholder="Сумма">
        <input class="submitBtn" type="submit" value="Отправить">
    </div>
</div>

<div class="title">Оплата услуг</div>
<form action="" method="post" id="transfer">
    <select class="options" onchange="showElem('container2', this.value)">
        <option selected="selected" disabled label="Вид перевода" value="1">Вид перевода</option>
        <option value="bankClient">Клиенту банка</option>
        <option value="btwAccounts">Между своими счетами</option>
    </select>

    <div id="container2">
        <div id="bankClient">
            <select class="options" onchange="showElem('container21', this.value)">
                <option selected="selected" disabled label="Вид перевода" value="1">Вид перевода</option>
                <option value="phoneNum">По номеру телефона</option>
                <option value="cardNum">По номеру карты</option>
            </select>
            <div id="container21">
                <div id="phoneNum">
                    <input type="text" placeholder="Номер телефона">
                    <input class="submitBtn" type="submit" value="Найти">
                </div>
                <div id="cardNum"></div>
            </div>
        </div>

        <div id="btwAccounts">
            <select class="options" onchange="">
                <option selected="selected" disabled label="Выберите карту" value="1">Выберите карту</option>
                <c:forEach items="${cards}" var="card">
                    <tr>
                        <option>${card.name}</option>
                    </tr>
                </c:forEach>
            </select>
        </div>
    </div>



</form>
</div>
</body>
</html>
