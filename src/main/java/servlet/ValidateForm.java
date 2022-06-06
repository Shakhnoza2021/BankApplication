package servlet;

import exception.UserNotFoundException;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValidateForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String > errors = new HashMap<>();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = new UserService();

        int userId = 0;

        //boolean emptyFields = request.getParameter("login").isEmpty() || request.getParameter("password").isEmpty();
        //System.out.println(emptyFields);
        if (request.getParameter("login").isEmpty()) {
            errors.put("login", "Введите логин");
        }
        if (request.getParameter("password").isEmpty()) {
            errors.put("password", "Введите пароль");
        }

    }
}
