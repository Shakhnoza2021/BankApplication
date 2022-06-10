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
    <title>Платежи</title>
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

<div class="outerCont">
    <div class="title">Платежи</div>
    <div id="container1" class="container">
        <form action="" method="post" id="paymentsForm">
            <div id="payments" class="container">
                <select id="card" class="options" name="card">
                    <option selected="selected" disabled label="Карта" value="1">-- Номер карты --</option>
                    <c:forEach items="${cards}" var="card">
                        <option>${card.cardNum}</option>
                    </c:forEach>
                </select>

                <input type="hidden" name="selectedLabel" id="selectedLabel">
                <select id="paymentType" name="paymentType" class="options" onchange="showElem('container11', this.value), getSelectedLabel(this)">
                    <option selected="selected" disabled label="Услуга" value="1">-- Выберите услугу --</option>
                    <option value="phoneType">Телефонная связь</option>
                    <option value="fineType">Штрафы</option>
                    <option value="comServType">ЖКХ</option>
                </select>

                <div id="container11" class="container">
                    <div id="phoneType" class="container">
                        <select id="provider" class="options" name="provider">
                            <option selected="selected" disabled label="Оператор" value="1">-- Сотовый оператор --</option>
                            <option>Мегафон</option>
                            <option>МСТ</option>
                            <option>Билайн</option>
                        </select>

                        <div class="error">
                            <%
                                String err=(String)request.getAttribute("error");
                                if(err!=null){
                                    System.out.println("login_msg --------- " + err);
                                    out.println("<font color=red size=2px>"+err+"</font>");}


                            %></div>
                        <input id="numOfPhone" name="numOfPhone" type="text" placeholder="Номер телефона">
                        <input id="sumPhone" name="sumPhone" type="text" placeholder="Сумма">

                        <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Оплатить">
                    </div>

                    <div id="fineType" class="container">
                        <select class="options" name="fine">
                            <option selected="selected" disabled label="Организация" value="1">-- Организация --</option>
                            <option>Штрафы (ГИБДД, МВД)</option>
                            <option>Администрация</option>
                            <option>ФССП(судебные)</option>
                        </select>
                        <input name="docNum" type="text" placeholder="Номер документа">
                        <input name="fineSum" type="text" placeholder="Сумма">
                        <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Оплатить">
                    </div>
                    <div id="comServType" class="container">
                        <select class="options" name="comServ">
                            <option selected="selected" disabled label="Название ЖКУ" value="1">-- Название ЖКУ --</option>
                            <option>Электроэнергия</option>
                            <option>Холодная вода</option>
                            <option>Горячая вода</option>
                            <option>Отопление</option>
                            <option>Вывоз мусора</option>
                        </select>
                        <select class="options" name="org">
                            <option selected="selected" disabled label="Организация" value="1">-- Организация --</option>
                            <option>НСК РТС</option>
                            <option>Водоканал</option>
                            <option>УК Гарант</option>
                        </select>
                        <input name="personalAcc" type="text" placeholder="Личный кабинет">
                        <input name="comServSum" type="text" placeholder="Сумма">
                        <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Оплатить">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
