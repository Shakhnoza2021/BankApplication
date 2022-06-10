package servlet.manager;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUser", urlPatterns = {"/addUser", "/secure/managerView/addUser"})
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("user", request.getSession().getAttribute("user"));

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String patronymic = request.getParameter("patronymic");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setPhoneNum(phoneNum);
        user.setEmail(email);

        System.out.println("add user " + user.toString());

        UserService service = new UserService();
        service.addUser(user);

        RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/add.jsp");
        rd.include(request, response);
    }
}
