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

<div class="outerCont">
    <div class="title">Платежи и переводы</div>
        <select class="options" onchange="showElem('container1', this.value)">
            <option selected="selected" disabled label="Услуга" value="1">-- Выберите услугу --</option>
            <option value="payments">Платежи</option>
            <option value="transfer">Переводы</option>
        </select>
        <div id="container1" class="container">
            <form action="" method="post" id="paymentsForm">
                <div id="payments" class="container">
                    <input type="hidden" name="selectedLabel" id="selectedLabel">
                    <select id="paymentType" name="paymentType" class="options" onchange="showElem('container11', this.value), getSelectedLabel(this)">
                        <option selected="selected" disabled label="Услуга" value="1">-- Выберите услугу --</option>
                        <option value="phoneType">Телефонная связь</option>
                        <option value="fineType">Штрафы</option>
                        <option value="comServType">ЖКХ</option>
                    </select>

                    <select id="account" class="options" name="account">
                            <option selected="selected" disabled label="Счёт" value="1">-- Счёт --</option>
                            <c:forEach items="${accounts}" var="account">
                            <option>${account.accountNum}</option>
                            </c:forEach>
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

                            <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Отправить">
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
                            <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Отправить">
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
                            <input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Отправить">
                        </div>
                    </div>
                </div>
                <!--<input formaction="payments" formmethod="post" class="submitBtn" type="submit" value="Отправить">-->
            </form>
            <form action="" method="post" id="transferForm">
                <div id="transfer" class="container">
                    <select class="options" onchange="showElem('container12', this.value)">
                        <option selected="selected" disabled label="Вид перевода" value="1">Вид перевода</option>
                        <option value="bankClient">Клиенту банка</option>
                        <option value="btwAccounts">Между своими счетами</option>
                    </select>

                    <div id="container12" class="container">
                        <div id="bankClient" class="container">
                            <select class="options" onchange="showElem('container121', this.value)">
                                <option selected="selected" disabled label="Вид перевода" value="1">Вид перевода</option>
                                <option value="phoneNum">По номеру телефона</option>
                                <option value="cardNum">По номеру карты</option>
                            </select>
                            <div id="container121" class="container">
                                <div id="phoneNum" class="container">
                                    <input type="text" placeholder="Номер телефона">
                                    <input formaction="transfer" formmethod="post" class="submitBtn" type="submit" value="Найти">
                                </div>
                                <div id="cardNum" class="container">
                                    <input type="text" placeholder="Номер карты">
                                    <input formaction="transfer" formmethod="post" class="submitBtn" type="submit" value="Найти">
                                </div>
                            </div>
                        </div>

                        <div id="btwAccounts" class="container">
                            <select class="options" onchange="">
                                <option selected="selected" disabled label="Выберите карту" value="1">Откуда</option>
                                <c:forEach items="${cards}" var="card">
                                    <tr>
                                        <option>${card.name}</option>
                                    </tr>
                                </c:forEach>
                            </select>
                            <select class="options" onchange="">
                                <option selected="selected" disabled label="Выберите карту" value="1">Куда</option>
                                <c:forEach items="${cards}" var="card">
                                    <tr>
                                        <option>${card.name}</option>
                                    </tr>
                                </c:forEach>
                            </select>
                            <input type="text" placeholder="Сумма">
                            <input formaction="transfer" formmethod="post" class="submitBtn" type="submit" value="Отправить">
                        </div>
                    </div>

                </div>
            </form>
        </div>

</div>
</body>
</html>
