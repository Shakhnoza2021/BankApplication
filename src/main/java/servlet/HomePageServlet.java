package servlet;

import exception.UserNotFoundException;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "homePage", urlPatterns = "/homePage")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.setProperty("file.encoding","UTF-8");

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("request encoding " + request.getCharacterEncoding());
        System.out.println("response encoding " + response.getCharacterEncoding());
        PrintWriter writer = response.getWriter();


        String login = request.getParameter("login");
        String password = request.getParameter("password");

        System.out.println(login + " " + password);

        //Encryption encryption = new Encryption();
        HttpSession session = request.getSession();

        UserService userService = new UserService();

        int userId = 0;

        //boolean emptyFields = request.getParameter("login").isEmpty() || request.getParameter("password").isEmpty();
        //System.out.println(emptyFields);
       //if (!emptyFields) {
            try {
                userId = userService.getUserId(login, password);
                if (userId == 0) {
                    throw new UserNotFoundException("Неверные логин или пароль");
                }


                if (userId != 0) {
                    System.out.println("UserID not null");
                    User user = userService.getUserByPhoneNum(login, password);
                    if (user.getRole().equals("user")) {
                        userService.setSessionAttribute(user, session);
                        System.out.println("redirected to user.jsp");
                        System.out.println("Session attribute Name = " + request.getSession().getAttribute("name"));
                        RequestDispatcher rd = request.getRequestDispatcher("secure/userView/user.jsp");
                        rd.forward(request, response);
                    }
                    if (user.getRole().equals("manager")) {
                        userService.setSessionAttribute(user, session);
                        System.out.println("redirected to manager.jsp");
                        RequestDispatcher rd = request.getRequestDispatcher("secure/managerView/manager.jsp");
                        rd.forward(request, response);

                    }
                } else {
                    System.out.println("login from HomePage");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } catch (UserNotFoundException ex) {
                System.out.println(ex.getMessage());
                request.setAttribute("error", "Неверные логин или пароль");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
