<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cards" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="client" class="model.User" scope="request"/>
<jsp:useBean id="errorUser" class="java.lang.String" scope="request"/>
<jsp:useBean id="errorSum" class="java.lang.String" scope="request"/>
<jsp:useBean id="errorInput" class="java.lang.String" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/user.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/table.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/checkParams.js'/>"></script>
    <title>Переводы</title>
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

    <table>
        <tr>
            <td class="align">
                <div class="title">Перевод клиенту банка</div>
                <form action="" method="post" id="toBankClient">
                    <div>
                        <div class="error">
                            <%
                                if(errorUser!=null){
                                    out.println("<font color=red size=2px>"+ errorUser +"</font>");}
                            %></div>
                        <input name="number" type="text" placeholder="Номер телефона или карты">
                    </div>
                    <!--<input name="client" type="text" placeholder="${client.lastName} ${client.name} ${client.patronymic}">-->
                    <div class="error">
                        <%
                            if(errorInput!=null){
                                out.println("<font color=red size=2px>"+ errorInput +"</font>");}
                        %></div>
                    <select name="fromCard" class="options">
                        <option selected="selected" disabled label="Счет списания" value="1">Списать с карты</option>
                        <c:forEach items="${cards}" var="card">
                            <option>${card.cardNum}</option>
                        </c:forEach>
                    </select>
                    <div class="error">
                        <%
                            if(errorSum!=null){
                                out.println("<font color=red size=2px>"+errorSum+"</font>");}
                        %></div>
                    <input name="transferSum" type="text" placeholder="Сумма">
                    <input formaction="transferTo" formmethod="post" class="submitBtn" type="submit" value="Перевести">
                </form>
            </td>
            <td class="align">
                <div class="title">Перевод между своими счетами</div>
                <form action="" method="post" id="btwAccounts">
                    <div>
                    <select class="options" onchange="">
                        <option name="debitCard" selected="selected" disabled label="Счет списания" value="1">Списать с карты</option>
                        <c:forEach items="${cards}" var="card">
                        <option>${card.cardNum}</option>
                        </c:forEach>
                    </select>
                    <select class="options" onchange="">
                        <option name="transferCard" selected="selected" disabled label="Счет зачисления" value="1">Зачислить на карту</option>
                        <c:forEach items="${cards}" var="card">
                        <option>${card.cardNum}</option>
                        </c:forEach>
                    </select>

                        <input type="text" placeholder="Сумма">
                        <input formaction="transferBtw" formmethod="post" class="submitBtn" type="submit" value="Перевести">
                    </div>
                </form>
            </td>
        </tr>
    </table>
    </div>
</div>
</body>
</html>