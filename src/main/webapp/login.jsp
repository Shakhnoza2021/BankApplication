<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="stylesheets/login.css">
    <script type="text/javascript" src="scripts/checkParams.js"></script>
    <title>Online_Bank</title>
</head>
<body>
<form accept-charset="UTF-8" action="homePage" method="post">
    <div class="outer">
        <div class="middle">
            <div class="inner">
                <div class="login-form">
                    <h2>Вход</h2>
                    <div class="form">
                        <input type="text" id="login" name="login" onkeyup="checkParams()" placeholder="Пользователь">
                        <input type="password" id="password" name="password" onkeyup="checkParams()" placeholder="Пароль">
                        <div class="error"> <%
                            String login_msg=(String)request.getAttribute("error");
                            if(login_msg!=null){
                                System.out.println("login_msg --------- " + login_msg);
                                out.println("<font color=red size=2px>"+login_msg+"</font>");}
                        %></div>
                        <button id="send" type="submit" value="login" disabled="disabled"> Авторизация </button>
                    </div>
                </div>

                <div class="welcome">Добро пожаловать<br> в НСК Онлайн
                    <p>Если вы не помните пароль, <br>зарегистрируйтесь по номеру <br>вашей банковской карты</p>
                </div>

            </div>
        </div>
    </div>
</form>
</body>
</html>