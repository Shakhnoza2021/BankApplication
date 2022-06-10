package servlet.manager;

import exception.UserNotFoundException;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editUser", urlPatterns = {"/editUser", "/secure/managerView/editUser"})
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("user", request.getSession().getAttribute("user"));

        User user = (User) request.getAttribute("client");

        //User user = (User) request.getSession().getAttribute("user");

        String name = request.getParameter("name");
        if (!name.equals("")){
            user.setName(name);
        }

        String lastName = request.getParameter("lastName");
        if (!lastName.equals("")){
            user.setLastName(lastName);
        }

        String patronymic = request.getParameter("patronymic");
        if (!patronymic.equals("")){
            user.setPatronymic(patronymic);
        }

        String phoneNum = request.getParameter("phoneNum");
        if (!phoneNum.equals("")){
            user.setPhoneNum(phoneNum);
        }

        String email = request.getParameter("email");
        if (!email.equals("")){
            user.setEmail(email);
        }

        UserService service = new UserService();
        service.updateUser(user);

        request.setAttribute("user", user);
        request.getSession().setAttribute("user", user);

        request.setAttribute("client", user);
        RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/clients.jsp");
        rd.include(request, response);
    }
}
